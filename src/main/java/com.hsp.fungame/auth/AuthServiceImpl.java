package com.hsp.fungame.auth;

import com.hsp.fungame.player.Player;
import com.hsp.fungame.player.PlayerRepository;
import com.hsp.fungame.player.Role;
import com.hsp.fungame.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (playerRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if (playerRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        Player player = Player.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.PLAYER)
                .createdAt(LocalDateTime.now())
                .build();

        playerRepository.save(player);

        String jwt = jwtService.generateToken(player);

        return AuthResponse.builder()
                .token(jwt)
                .build();
    }
    @Override
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        Player player = playerRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new UsernameNotFoundException("Player not found"));

        String jwt = jwtService.generateToken(player);

        return AuthResponse.builder()
                .token(jwt)
                .build();
    }
}
