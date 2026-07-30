package com.hsp.fungame.room;

import com.hsp.fungame.room.dto.CreateRoomResponse;
import com.hsp.fungame.room.dto.JoinRoomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/join/{roomCode}")
    public JoinRoomResponse joinRoom(
            @PathVariable String roomCode,
            Authentication authentication) {

        return gameRoomService.joinRoom(roomCode, authentication);
    }
}
