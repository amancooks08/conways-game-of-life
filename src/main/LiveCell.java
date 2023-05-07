package main;

public class LiveCell implements Cell{
    public static final Cell Instance = new LiveCell();

    private LiveCell(){
    }
    public boolean isAlive(){
        return true;
    }

    public Cell nextGeneration(int aliveNeighbours){
        return this;
    }
}
