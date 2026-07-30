package com.hsp.fungame.game;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StartGameResponse {
    private String roomCode;

    private String board;

    private String currentTurn;

    private String status;
}
