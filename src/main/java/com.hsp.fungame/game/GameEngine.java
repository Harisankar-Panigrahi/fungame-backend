package com.hsp.fungame.game;

import org.springframework.stereotype.Component;

@Component
public class GameEngine {
    public String makeMove(String board, int position, char symbol) {

        char[] cells = board.toCharArray();

        if (position < 0 || position > 8) {
            throw new RuntimeException("Invalid position");
        }

        if (cells[position] != '_') {
            throw new RuntimeException("Cell already occupied");
        }

        cells[position] = symbol;

        return new String(cells);
    }

    public boolean isDraw(String board) {
        return !board.contains("_");
    }
    public boolean hasWinner(String board) {

        char[] b = board.toCharArray();

        int[][] wins = {
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,3,6},
                {1,4,7},
                {2,5,8},
                {0,4,8},
                {2,4,6}
        };

        for (int[] w : wins) {

            if (b[w[0]] != '_'
                    && b[w[0]] == b[w[1]]
                    && b[w[1]] == b[w[2]]) {

                return true;
            }
        }

        return false;
    }
}
