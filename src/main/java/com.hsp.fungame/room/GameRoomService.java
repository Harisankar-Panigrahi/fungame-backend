package com.hsp.fungame.room;

import com.hsp.fungame.room.dto.CreateRoomResponse;
import com.hsp.fungame.room.dto.JoinRoomResponse;
import com.hsp.fungame.room.dto.MoveRequest;
import com.hsp.fungame.room.dto.MoveResponse;
import org.springframework.security.core.Authentication;

public interface GameRoomService {
    CreateRoomResponse createRoom(Authentication authentication);
    JoinRoomResponse joinRoom(String roomCode, Authentication authentication);
    MoveResponse makeMove(MoveRequest request, Authentication authentication);
}
