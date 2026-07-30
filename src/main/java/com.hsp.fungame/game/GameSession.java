package com.hsp.fungame.game;

import com.hsp.fungame.player.Player;
import com.hsp.fungame.room.GameRoom;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private GameRoom room;

    @ManyToOne
    private Player currentTurn;

    @ManyToOne
    private Player winner;

    @Enumerated(EnumType.STRING)
    private GameStatus status;

    @Column(length = 9)
    private String board;
}
