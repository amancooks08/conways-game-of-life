package test;

import main.CellAddress;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellAddressTest {

    @Nested
    class TestForConstructor{

        @Test
        public void testExceptionForNegativeValues(){
            IllegalArgumentException exception =  assertThrows(IllegalArgumentException.class, () -> new CellAddress(-1, 3));
            assertEquals("Address indices can't be negative for a grid.", exception.getMessage());
        }

        @Test
        public void testConstructorForValidValues(){
            assertDoesNotThrow(() -> new CellAddress(1, 3));
        }
    }

}
