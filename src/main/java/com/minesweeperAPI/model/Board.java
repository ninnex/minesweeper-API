package com.minesweeperAPI.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import static com.minesweeperAPI.constants.Constants.HIDE;

@Getter
@Setter
@JsonDeserialize
@AllArgsConstructor
@NoArgsConstructor
public class Board {


    private int n;
    private int m;
    private int [][]matriz;

    private int [][]mines;

    private String status;



    public Board(int n, int m){
        this.n = n;
        this.m = m;
        matriz = new int[n][m];
        mines = new int[n][m];
        this.status = "playing";
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
