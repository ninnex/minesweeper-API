package com.minesweeperAPI.services;

import com.minesweeperAPI.model.Board;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

import static com.minesweeperAPI.constants.Constants.*;

@Service
@AllArgsConstructor
public class BoardBusiness {



    public Board initMatriz(Board board){
        for (int i = 0; i < board.getN(); i++)
            for (int j = 0; j < board.getM(); j++)
                board.setMatriz(i,j, HIDE);
        board = putMines(board, MINES_AMOUNT);
        board = setMinesNumber(board);
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


    private Board setMinesNumber(Board board){
        for (int i = 0; i < board.getN(); i++)
            for (int j = 0; j < board.getM(); j++)
                board.setMines(i, j, howManyMines(board, i, j));
        return board;
    }

    private int howManyMines(Board board, int x, int y){

        if(board.getMines(x, y) == MINE)
            return MINE;
        int n = board.getN(), m = board.getM();
        int ix = -1, sx = 1, iy = -1, sy = 1;
        if(x + ix <  0) ix = 0;
        if(x + sx >= n) sx = 0;
        if(y + iy <  0) iy = 0;
        if(y + sy >= m) sy = 0;
        int count = 0;

        for (int i = ix; i <= sx; i++)
            for (int j = iy; j <= sy; j++)
                if(board.getMines(x+i, y+j) == MINE)
                    count++;
        return count ;
    }


}
