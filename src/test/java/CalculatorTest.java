import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        int actualResult = calculator.add(2, 3);

        assertEquals(5, actualResult);
    }
}