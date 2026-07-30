package com.hsp.fungame.room;

import com.hsp.fungame.room.dto.CreateRoomResponse;
import org.springframework.security.core.Authentication;

public interface GameRoomService {
    CreateRoomResponse createRoom(Authentication authentication);
}
