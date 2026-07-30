package com.hsp.fungame.room;

import com.hsp.fungame.player.Player;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String roomCode;

    @ManyToOne
    private Player host;

    @ManyToOne
    private Player guest;

    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    private LocalDateTime createdAt;

}
