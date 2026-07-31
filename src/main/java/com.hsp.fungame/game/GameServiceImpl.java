package com.hsp.fungame.game;

import com.hsp.fungame.room.GameRoom;
import com.hsp.fungame.room.GameRoomRepository;
import com.hsp.fungame.room.RoomStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{
    private final GameRoomRepository gameRoomRepository;
    private final GameSessionRepository gameSessionRepository;



    @Override
    public StartGameResponse startGame(String roomCode, Authentication authentication) {
        GameRoom room = gameRoomRepository.findByRoomCode(roomCode)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        if (room.getStatus() != RoomStatus.FULL) {
            throw new RuntimeException("Room must have two players");
        }

        if (!room.getHost().getEmail().equals(authentication.getName())) {
            throw new RuntimeException("Only host can start the game");
        }

        if (gameSessionRepository.existsByRoom(room)) {
            throw new RuntimeException("Game already started");
        }

        GameSession session = GameSession.builder()
                .room(room)
                .board("_________")
                .currentTurn(room.getHost())
                .status(GameStatus.IN_PROGRESS)
                .build();

        gameSessionRepository.save(session);
        return StartGameResponse.builder()
                .roomCode(room.getRoomCode())
                .board(session.getBoard())
                .currentTurn(session.getCurrentTurn().getUsername())
                .status(session.getStatus().name())
                .build();
    }
}
