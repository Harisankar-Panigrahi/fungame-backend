package com.hsp.fungame.room;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class RoomCodeGenerator {
    private static final String CHARACTERS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final int LENGTH = 6;

    private final SecureRandom random = new SecureRandom();

    public String generateCode() {

        StringBuilder code = new StringBuilder();

        for (int i = 0; i < LENGTH; i++) {

            code.append(
                    CHARACTERS.charAt(
                            random.nextInt(CHARACTERS.length())
                    )
            );
        }

        return code.toString();
    }
}
