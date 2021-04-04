package com.minesweeperAPI.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.ThreadLocalRandom;

import java.util.Arrays;

@Getter
@Setter
public class Board {


    private int n;
    private int m;
    private int [][]matriz;

    private final int MINE   = 10;
    private final int HIDE   = 9;
    private final int EMPTY  = 0;

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


    public void play(int x, int y){
        if(this.matriz[x][y] == HIDE) {
            this.matriz[x][y] = this.mines[x][y];
        }
    }





}