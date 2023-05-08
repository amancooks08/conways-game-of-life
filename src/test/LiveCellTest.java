package test;

import main.Cell;
import main.DeadCell;
import main.LiveCell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiveCellTest {

    @Test
    public void liveCellStaysAlive(){
        assertTrue(LiveCell.Instance.isAlive());
    }

    @Test
    public void aliveCellWithLessThanTwoAliveNeighboursDies(){
        Cell cell = LiveCell.Instance.nextGeneration(1);
        assertFalse(cell.isAlive());
    }

    @Test
    public void aliveCellWithMoreThanThreeNeighboursDies(){
        Cell cell = LiveCell.Instance.nextGeneration(5);
        assertFalse(cell.isAlive());
    }

    @Test
    public void aliveCellWithTwoOrThreeAliveNeighboursStaysAlive(){
        Cell cell1 = LiveCell.Instance.nextGeneration(2);
        Cell cell2 = LiveCell.Instance.nextGeneration(3);

        assertTrue(cell1.isAlive());
        assertTrue(cell2.isAlive());
    }

    @Test
    public void expectExceptionForNegativeNeighbours(){
        assertThrows(IllegalArgumentException.class, () -> LiveCell.Instance.nextGeneration(-2));
    }
}