package com.hsp.fungame.room.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoveRequest {
    private String roomCode;

    private int position;
}
