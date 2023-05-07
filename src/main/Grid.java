package main;

import java.util.Random;

public class Grid {
    private Cell[][] cells;

    public Grid(int rows, int columns){
        if (rows <= 0 || columns <= 0){
            throw new IllegalArgumentException("Rows and Columns should be positive values");
        }
        cells = new Cell[rows][columns];
        for (int i=0; i<cells.length; i++){
            for (int j=0; j<cells[0].length; j++){
                cells[i][j] = DeadCell.Instance;
            }
        }
    }

    public void generateSeedGeneration(){
        Random rand = new Random();

        for (int i = 0; i < this.rows(); i++){
            for (int j = 0; j < this.columns(); j++){
                this.cells[i][j] = rand.nextInt(2) == 0 ? DeadCell.Instance : LiveCell.Instance;
            }
        }
    }

    public int rows(){
        return cells.length;
    }

    public int columns(){
        return cells[0].length;
    }
}
