package com.hsp.fungame.room.dto;

import com.hsp.fungame.room.RoomStatus;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRoomResponse {
    private String roomCode;
    private String hostUsername;
    private RoomStatus status;
}
