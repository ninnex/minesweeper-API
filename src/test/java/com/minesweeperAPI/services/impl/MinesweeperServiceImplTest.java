package com.minesweeperAPI.services.impl;

import com.minesweeperAPI.model.Action;
import com.minesweeperAPI.model.Board;
import com.minesweeperAPI.services.BoardBusiness;
import com.minesweeperAPI.services.MinesweeperService;
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

    @Autowired
    MinesweeperService service;

    final int MAX_MINES_NUMBER = 10;


    @Test
    void getBoard() {
        board = new Board(10,10);
        board = boardBusiness.initMatriz(board);
        assertTrue(checkMinesNumber(board));
    }



    @Test
    void markFag() {
        board = new Board(10,10);
        board = boardBusiness.initMatriz(board);
        service.setBoard(board);
        Action action = Action.builder().action("mark").x(0).y(0).build();
        board = service.markFag(action);
        assertEquals(board.getMatriz(0,0), 11);
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