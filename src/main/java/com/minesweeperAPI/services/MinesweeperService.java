package com.minesweeperAPI.services;

import com.minesweeperAPI.model.Action;
import com.minesweeperAPI.model.Board;

public interface MinesweeperService {

    public Board getBoard();

    public Board play(Action action);

    public Board markFag(Action action);

    public Board loadBoard(Action action);

    public Board saveBoard(Action action);

    public void setBoard(Board board);
}
