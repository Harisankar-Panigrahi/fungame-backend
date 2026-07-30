package com.hsp.fungame.game;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @PostMapping("/start/{roomCode}")
    public StartGameResponse startGame(
            @PathVariable String roomCode,
            Authentication authentication) {

        return gameService.startGame(roomCode, authentication);
    }
}
