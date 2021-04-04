package com.minesweeperAPI.model;


import lombok.Getter;
import lombok.Setter;


import static com.minesweeperAPI.constants.Constants.HIDE;

@Getter
@Setter
public class Board {


    private int n;
    private int m;
    private int [][]matriz;

    private int [][]mines;



    public Board(int n, int m){
        this.n = n;
        this.m = m;
        matriz = new int[n][m];
        mines = new int[n][m];
    }

    public void setMatriz(int x, int y, int val){
        this.matriz[x][y] = val;
    }

    public void setMines(int x, int y, int val){
        this.mines[x][y] = val;
    }

    public int getMatriz(int x, int y){
        return this.matriz[x][y];
    }
    public int getMines(int x, int y){
        return this.mines[x][y];
    }







}
