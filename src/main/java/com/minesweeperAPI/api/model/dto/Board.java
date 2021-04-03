package com.minesweeperAPI.api.model.dto;

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

    public void setVal(int x, int y, int val){
        this.matriz[x][y] = val;
    }



    public void initMatriz(){
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz.length; j++)
                 this.matriz[i][j] = HIDE;
    }

    public void play(int x, int y){
        if(this.matriz[x][y] == HIDE) {
            this.matriz[x][y] = this.mines[x][y];
        }
    }





}
