package test;

import main.Grid;
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

            assertEquals(deadGrid, grid);
        }

    }

    @Nested
    class TestTickNewGeneration{

        @Test
        public void expectDeadPopulationDoNotReproduce(){
            Grid grid = new Grid(5, 6);

            Grid nextGeneration = grid.tickPopulation();

            assertEquals(grid, nextGeneration);
        }

        @Test
        public void expectSeedPopulationToReproduce(){
            Grid grid = new Grid(5, 6);
            grid.generateSeed();

            Grid nextGeneration = grid.tickPopulation();

            assertNotEquals(grid, nextGeneration);
        }
    }
}