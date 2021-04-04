package com.minesweeperAPI.services.impl;

import com.minesweeperAPI.dao.BoardRepo;
import com.minesweeperAPI.model.Board;
import com.minesweeperAPI.model.BoardEntity;
import com.minesweeperAPI.services.BoardBusiness;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

import static com.minesweeperAPI.constants.Constants.*;

@Service
@RequiredArgsConstructor
public class BoardBusinessImpl implements BoardBusiness {

    @Autowired
    BoardRepo boardRepo;

    public Board play(Board board, int x, int y){
        if(board.getStatus().equals(LOOSE))
            return board;

        if(board.getMatriz(x, y) == HIDE) {
            board.setMatriz(x, y, board.getMines(x, y));
            if(board.getMatriz(x, y) == MINE)
                board.setStatus(LOOSE);
            if(board.getMatriz(x, y) == EMPTY)
                board = recursive(board, x, y);
        }
        if(isWon(board))
            board.setStatus(WIN);

        return  board;
    }


    public Board initMatriz(Board board){
        for (int i = 0; i < board.getN(); i++)
            for (int j = 0; j < board.getM(); j++)
                board.setMatriz(i,j, HIDE);
        board = putMines(board, MINES_AMOUNT);
        board = setMinesNumber(board);
        boardRepo.save(new BoardEntity(board, 1));
        return board;
    }

    public Board getMatrizFromRepo(int id){
        return boardRepo.findById(id).get().getBoardObject();

    }

    public Board saveMatrizFromRepo(Board board, int id){
        return boardRepo.save(new BoardEntity(board, id)).getBoardObject();
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

    private Board recursive(Board board, int x, int y){

        board.setMatriz(x, y, board.getMines(x, y));
        if(board.getMines(x, y) != EMPTY)
            return board;
        int n = board.getN(), m = board.getM();
        if(x < n-1 && board.getMatriz(x+1, y) == HIDE)
            board = recursive(board,x +1 , y);
        if(y < m-1 && board.getMatriz(x, y+1) == HIDE)
            board = recursive(board, x, y +1);
        if(x > 0   && board.getMatriz(x-1, y) == HIDE)
            board = recursive(board,x -1, y);
        if(y > 0   && board.getMatriz(x, y-1) == HIDE)
            board = recursive(board,x, y-1);

        return board;
    }


    public boolean isWon(Board board){
        for (int i = 0; i < board.getN(); i++) {
            for (int j = 0; j < board.getM(); j++) {

                if( board.getMatriz(i, j) == HIDE && (board.getMines(i, j) != MINE))
                    return false;
            }

        }


        return true;
    }


}
