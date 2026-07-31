package com.hsp.fungame.room.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoveResponse {
    private String board;

    private String nextTurn;

    private String winner;

    private String status;
}
