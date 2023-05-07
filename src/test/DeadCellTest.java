package test;

import main.Cell;
import main.DeadCell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadCellTest {
    @Test
    public void expectFalseOnIsAliveCall(){
        assertFalse(DeadCell.Instance.isAlive());
    }


    @Test
    public void expectToBeAliveWithThreeNeighbours(){
        Cell cell = DeadCell.Instance.nextGeneration(3);
        assertTrue(cell.isAlive());
    }

    @Test
    public void expectCellToRemainDead(){
        assertFalse(DeadCell.Instance.nextGeneration(0).isAlive());
        assertFalse(DeadCell.Instance.nextGeneration(2).isAlive());
        assertFalse(DeadCell.Instance.nextGeneration(4).isAlive());
    }
}