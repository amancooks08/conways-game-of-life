package main;

public class LiveCell implements Cell{
    public static final Cell Instance = new LiveCell();

    private LiveCell(){
    }
    public boolean isAlive(){
        return true;
    }

    public Cell nextGeneration(int aliveNeighbours) throws IllegalArgumentException{
        if (aliveNeighbours < 0){
            throw new IllegalArgumentException("Neighbours count be can't be negative");
        }
        if (aliveNeighbours < 2 || aliveNeighbours > 3){
            return DeadCell.Instance;
        }
        return this;
    }
}
