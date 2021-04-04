package com.minesweeperAPI.services;

import com.minesweeperAPI.model.Board;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class BoardBusiness {

    private static final int MINE   = 10;
    private static final int HIDE   = 9;
    private static final int EMPTY  = 0;
    private static final int MINES_AMOUNT = 10;

    public Board initMatriz(Board board){
        for (int i = 0; i < board.getN(); i++)
            for (int j = 0; j < board.getM(); j++)
                board.setMatriz(i,j, HIDE);
        board = putMines(board, MINES_AMOUNT);
        return board;
    }

    private Board putMines(Board board, int amount){
        int randomNumX, randomNumY;
        for (int i = 0; i < amount; i++) {
            do {
                randomNumX = ThreadLocalRandom.current().nextInt(0, board.getN());
                randomNumY = ThreadLocalRandom.current().nextInt(0, board.getM());
            } while(board.getMines(randomNumX, randomNumY) == MINE);

            board.setMines(randomNumX, randomNumY, MINE);
        }
        return board;
    }

}
