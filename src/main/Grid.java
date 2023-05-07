package main;

import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class Grid {
    private Cell[][] cells;

    public Grid(int rows, int columns) throws IllegalArgumentException{
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

    public void generateSeed(){
        Random rand = new Random();

        for (int i = 0; i < this.rows(); i++){
            for (int j = 0; j < this.columns(); j++){
                this.cells[i][j] = rand.nextInt(2) == 0 ? DeadCell.Instance : LiveCell.Instance;
            }
        }
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(cells);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid = (Grid) o;
        return Arrays.deepEquals(this.cells, grid.cells);
    }

    public int rows(){
        return cells.length;
    }

    public int columns(){
        return cells[0].length;
    }

    public void put(Cell cell, int x, int y) throws IllegalArgumentException{
        if (x < 0 || y < 0 || x >= this.cells.length || y >= this.cells[0].length){
            throw new IllegalArgumentException("Enter valid co-ordinates.");
        }
        cells[x][y] = cell;
    }


    public Grid tickPopulation() {
        Grid newGrid = new Grid(this.cells.length, this.cells[0].length);
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                Cell cell = cells[x][y];
                List<CellAddress> neighbours = new CellAddress(x, y).neighboursFor(this);
                int liveNeighbourCount = liveNeighboursCountFor(neighbours);
                Cell newCell = cell.nextGeneration(liveNeighbourCount);
                newGrid.put(newCell, x, y);
            }
        }
        return newGrid;
    }

    private int liveNeighboursCountFor(List<CellAddress> neighbours) {
        int counter = 0;
        for (CellAddress address : neighbours) {
            if (cells[address.x][address.y].isAlive()) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                if (cells[x][y].isAlive()) {
                    buffer.append("*");
                } else {
                    buffer.append("O");
                }
                buffer.append("  ");
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
