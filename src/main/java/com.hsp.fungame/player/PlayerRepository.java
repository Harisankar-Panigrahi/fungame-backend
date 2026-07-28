package com.hsp.fungame.player;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByEmail(String email);

    Optional<Player> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}