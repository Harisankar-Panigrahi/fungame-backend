package com.hsp.fungame.game;

import com.hsp.fungame.room.GameRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
    Optional<GameSession> findByRoom(GameRoom room);
    boolean existsByRoom(GameRoom room);
}
