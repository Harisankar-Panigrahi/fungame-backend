package com.hsp.fungame.game;

import org.springframework.security.core.Authentication;

public interface GameService {
    StartGameResponse startGame(String roomCode,
                                Authentication authentication);
}
