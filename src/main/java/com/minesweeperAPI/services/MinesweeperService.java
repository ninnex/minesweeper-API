package com.minesweeperAPI.services;

import com.minesweeperAPI.model.Action;
import com.minesweeperAPI.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MinesweeperService {

    Board board;
    @Autowired
    BoardBusiness boardBusiness;

    public Board getBoard(){
        board = new Board(10,10);
        return boardBusiness.initMatriz(board);
    }

    public Board play(Action action){
        System.out.println(action);
        board = boardBusiness.play(board, action.getX(), action.getY());
        return board;
    }

    public Board markFag(Action action){
        System.out.println(action);
        board.setMatriz(action.getX(), action.getY(), 11);
        return board;
    }

}
