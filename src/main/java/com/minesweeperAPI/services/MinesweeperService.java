package com.minesweeperAPI.services;

import com.minesweeperAPI.api.model.dto.Action;
import com.minesweeperAPI.api.model.dto.Board;
import org.springframework.stereotype.Service;

@Service
public class MinesweeperService {

    Board board;

    public Board getBoard(){
        board = new Board(10,10);
        board.initMatriz();
        return board;
    }

    public Board play(Action action){
        System.out.println(action);
        board.play(action.getX(), action.getY());
        return board;
    }

    public Board markFag(Action action){
        System.out.println(action);
        board.setVal(action.getX(), action.getY(), 11);
        return board;
    }

}
