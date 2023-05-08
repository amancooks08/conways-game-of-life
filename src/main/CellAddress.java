package main;

import java.util.ArrayList;
import java.util.List;

public class CellAddress {
    public final int x;
    public final int y;

    public CellAddress(int x, int y) throws IllegalArgumentException{
        if (x < 0 || y < 0){
            throw new IllegalArgumentException("Address indices can't be negative for a grid.");
        }
        this.x = x;
        this.y = y;
    }


    public List<CellAddress> neighboursFor(Grid grid) {
        int lastRowIndex = grid.rows() - 1;
        int lastColumnIndex = grid.columns() - 1;
        List<CellAddress> neighbours = new ArrayList<>();
        for (int row = x - 1; row <= x + 1; row++) {
            for (int column = y - 1; column <= y + 1; column++) {
                if (row < 0 || column < 0 || row > lastRowIndex || column > lastColumnIndex || (row == x && column ==y)) {
                    continue;
                }
                neighbours.add(new CellAddress(row, column));
            }
        }
        return neighbours;
    }
}
