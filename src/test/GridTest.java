package test;

import main.Grid;
import main.LiveCell;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Nested
    class TestGridConstructor {

        @Test
        public void expectGridOfGiveSize() {
            assertDoesNotThrow(() -> new Grid(5, 6));
        }

        @Test
        public void expectExceptionForNegativeRows() {
            assertThrows(IllegalArgumentException.class, () -> new Grid(-3, 4));
        }

        @Test
        public void expectExceptionForNegativeColumns() {
            assertThrows(IllegalArgumentException.class, () -> new Grid(3, -4));
        }

        @Test
        public void expectExceptionForZeroColumns(){
            assertThrows(IllegalArgumentException.class, () -> new Grid(3, 0));
        }

        @Test
        public void expectExceptionForZeroRows() {
            assertThrows(IllegalArgumentException.class, () -> new Grid(0, 4));
        }

    }


    @Nested
    class TestSeedGenerator {
        @Test
        public void expectRandomSeedPopulation(){
            Grid deadGrid = new Grid(5, 6);
            Grid grid = new Grid(5, 6);
            grid.generateSeed();

            assertNotEquals(grid, deadGrid);
        }

    }

    @Nested
    class TestTickNewGeneration{

        @Test
        public void expectDeadPopulationToNotReproduce(){
            Grid grid = new Grid(5, 6);

            Grid nextGeneration = grid.tickPopulation();

            assertEquals(grid, nextGeneration);
        }

        @Test
        public void expectPopulationDisplayed(){
            Grid grid = new Grid(8, 8);
            grid.put(LiveCell.Instance, 4, 3);
            grid.put(LiveCell.Instance, 4, 4);
            grid.put(LiveCell.Instance, 4, 5);

            Grid newGrid = grid.tickPopulation();
            Grid expectedGrid = new Grid(8, 8);
            expectedGrid.put(LiveCell.Instance, 3, 4);
            expectedGrid.put(LiveCell.Instance, 4, 4);
            expectedGrid.put(LiveCell.Instance, 5, 4);
            assertEquals(expectedGrid, newGrid);
        }
    }

    @Nested
    class TestDisplayPopulation {

        @Test
        public void expectPopulationDisplayed() throws IllegalArgumentException{
            Grid grid = new Grid(8, 8);
            grid.put(LiveCell.Instance, 4, 3);
            grid.put(LiveCell.Instance, 4, 4);
            grid.put(LiveCell.Instance, 4, 5);

            System.out.println(grid);
            Grid newGrid = grid.tickPopulation();
            Grid expectedGrid = new Grid(8, 8);
            expectedGrid.put(LiveCell.Instance, 3, 4);
            expectedGrid.put(LiveCell.Instance, 4, 4);
            expectedGrid.put(LiveCell.Instance, 5, 4);

            System.out.println(expectedGrid.toString());
            System.out.println(newGrid.toString());

            newGrid = newGrid.tickPopulation();
            System.out.println(expectedGrid.toString());
            System.out.println(newGrid.toString());
        }
    }
}