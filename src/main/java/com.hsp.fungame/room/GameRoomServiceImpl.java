package com.hsp.fungame.room;

import com.hsp.fungame.player.Player;
import com.hsp.fungame.player.PlayerRepository;
import com.hsp.fungame.room.dto.CreateRoomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GameRoomServiceImpl implements GameRoomService{

    private final GameRoomRepository gameRoomRepository;
    private final PlayerRepository playerRepository;
    private final RoomCodeGenerator roomCodeGenerator;

    @Override
    public CreateRoomResponse createRoom(Authentication authentication) {
        String email = authentication.getName();

        Player host = playerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        String roomCode;

        do {
            roomCode = roomCodeGenerator.generateCode();
        } while (gameRoomRepository.existsByRoomCode(roomCode));

        GameRoom room = GameRoom.builder()
                .roomCode(roomCode)
                .host(host)
                .status(RoomStatus.WAITING)
                .createdAt(LocalDateTime.now())
                .build();

        gameRoomRepository.save(room);

        return CreateRoomResponse.builder()
                .roomCode(room.getRoomCode())
                .hostUsername(host.getUsername())
                .status(room.getStatus())
                .build();
    }
}
