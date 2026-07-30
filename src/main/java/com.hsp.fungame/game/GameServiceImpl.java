package com.hsp.fungame.game;

import com.hsp.fungame.room.GameRoomRepository;
import org.springframework.security.core.Authentication;

public class GameServiceImpl implements GameService{
    private final GameRoomRepository gameRoomRepository;
    private final GameSessionRepository gameSessionRepository;

    public GameServiceImpl(GameRoomRepository gameRoomRepository, GameSessionRepository gameSessionRepository) {
        this.gameRoomRepository = gameRoomRepository;
        this.gameSessionRepository = gameSessionRepository;
    }

    @Override
    public StartGameResponse startGame(String roomCode, Authentication authentication) {
        return null;
    }
}
