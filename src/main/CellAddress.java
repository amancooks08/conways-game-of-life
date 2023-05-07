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
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || j < 0 || i > lastRowIndex || j > lastColumnIndex || (i == x && j ==y)) {
                    continue;
                }
                neighbours.add(new CellAddress(i, j));
            }
        }
        return neighbours;
    }
}
