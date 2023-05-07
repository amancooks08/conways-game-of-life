package main;

public class DeadCell implements Cell{
    public static final Cell Instance = new DeadCell();

    private DeadCell() {
    }

    public boolean isAlive(){
        return false;
    }

    public Cell nextGeneration(int aliveNeighbours){
        if (aliveNeighbours == 3){
            return LiveCell.Instance;
        }
        return this;
    }
}
