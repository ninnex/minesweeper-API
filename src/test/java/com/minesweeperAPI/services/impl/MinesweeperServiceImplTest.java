package com.minesweeperAPI.services.impl;

import com.minesweeperAPI.model.Board;
import com.minesweeperAPI.services.BoardBusiness;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.minesweeperAPI.constants.Constants.MINE;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MinesweeperServiceImplTest {

    Board board;
    @Autowired
    BoardBusiness boardBusiness;

    final int MAX_MINES_NUMBER = 10;


    @Test
    void getBoard() {
        board = new Board(10,10);
        board = boardBusiness.initMatriz(board);
        assertTrue(checkMinesNumber(board));
    }

    @Test
    void play() {
    }

    @Test
    void markFag() {
    }

    @Test
    void loadBoard() {
    }

    @Test
    void saveBoard() {
    }




    private boolean checkMinesNumber(Board board){
        int count = 0 ;
        for (int i = 0; i < board.getN(); i++)
            for (int j = 0; j < board.getM(); j++)
                if(board.getMines(i, j) == MINE)
                    count++;
        return count == MAX_MINES_NUMBER;
    }
}