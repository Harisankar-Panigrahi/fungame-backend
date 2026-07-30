package com.hsp.fungame.room;

import com.hsp.fungame.room.dto.CreateRoomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class GameRoomController {
    private final GameRoomService gameRoomService;

    @PostMapping("/create")
    public CreateRoomResponse createRoom(Authentication authentication) {

        return gameRoomService.createRoom(authentication);
    }
}
