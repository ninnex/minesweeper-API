package com.minesweeperAPI.services;

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

}