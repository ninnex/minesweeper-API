package com.minesweeperAPI.services.impl;

import com.minesweeperAPI.model.Action;
import com.minesweeperAPI.model.Board;
import com.minesweeperAPI.services.BoardBusiness;
import com.minesweeperAPI.services.MinesweeperService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Setter
public class MinesweeperServiceImpl implements MinesweeperService {

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

    public Board loadBoard(Action action){
        System.out.println(action);
        board = boardBusiness.getMatrizFromRepo(1);
        return board;
    }
    public Board saveBoard(Action action){
        System.out.println(action);
        return boardBusiness.saveMatrizFromRepo(board, 1);

    }

}
