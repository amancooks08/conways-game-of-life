package main;

public class CellAddress {
    private final int x;
    private final int y;

    public CellAddress(int x, int y) throws IllegalArgumentException{
        if (x < 0 || y < 0){
            throw new IllegalArgumentException("Address indices can't be negative for a grid.");
        }
        this.x = x;
        this.y = y;
    }
}
