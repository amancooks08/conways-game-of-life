package main;

public interface Cell {
    boolean isAlive();
    Cell nextGeneration(int aliveNeighbours);
}
