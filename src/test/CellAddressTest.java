package test;

import main.CellAddress;
import main.DeadCell;
import main.Grid;
import main.LiveCell;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CellAddressTest {

    @Test
    public void testExceptionForNegativeValues(){
        IllegalArgumentException exception =  assertThrows(IllegalArgumentException.class, () -> new CellAddress(-1, 3));
        assertEquals("Address indices can't be negative for a grid.", exception.getMessage());
    }

    @Test
    public void testConstructorForValidValues(){
        assertDoesNotThrow(() -> new CellAddress(1, 3));
    }

    @Nested
    class TestNeighboursFor {

        @Test
        public void expectNeighboursForCenterCell(){
            Grid grid = new Grid(3,3);
            CellAddress centerCell = new CellAddress(1,1);

            List<CellAddress> neighbours = centerCell.neighboursFor(grid);

            assertEquals(8, neighbours.size());
            assertTrue(neighbours.contains(new CellAddress(0, 0)));
            assertTrue(neighbours.contains(new CellAddress(0, 1)));
            assertTrue(neighbours.contains(new CellAddress(0, 2)));
            assertTrue(neighbours.contains(new CellAddress(1, 0)));
            assertTrue(neighbours.contains(new CellAddress(1, 2)));
            assertTrue(neighbours.contains(new CellAddress(2, 0)));
            assertTrue(neighbours.contains(new CellAddress(2, 1)));
            assertTrue(neighbours.contains(new CellAddress(2, 2)));
        }

        @Test
        public void expectNeighboursForCornerCell(){
            Grid grid = new Grid(3,3);
            CellAddress cornerCell = new CellAddress(0,2);

            List<CellAddress> neighbours = cornerCell.neighboursFor(grid);

            assertEquals(3, neighbours.size());
            assertTrue(neighbours.contains(new CellAddress(0,1)));
            assertTrue(neighbours.contains(new CellAddress(1,2)));
            assertTrue(neighbours.contains(new CellAddress(1,1)));
        }

    }
}
