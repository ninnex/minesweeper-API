package com.minesweeperAPI.services;

import com.minesweeperAPI.model.Board;
import com.minesweeperAPI.model.BoardEntity;

import java.util.concurrent.ThreadLocalRandom;

import static com.minesweeperAPI.constants.Constants.EMPTY;
import static com.minesweeperAPI.constants.Constants.HIDE;
import static com.minesweeperAPI.constants.Constants.LOOSE;
import static com.minesweeperAPI.constants.Constants.MINE;
import static com.minesweeperAPI.constants.Constants.MINES_AMOUNT;
import static com.minesweeperAPI.constants.Constants.WIN;

public interface BoardBusiness {

    public Board play(Board board, int x, int y);

    public Board initMatriz(Board board);

    public Board saveMatrizFromRepo(Board board, int id);

    public Board getMatrizFromRepo(int id);

    public boolean isWon(Board board);

}
