import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AfterAllTest {

    static Calculator calculator;

    @BeforeAll
    static void init() {
        calculator = new Calculator();
    }

    @AfterAll
    static void tearDown() {
        calculator = null;
    }

    @Test
    @DisplayName("Test add method")
    void testAdd() {
        int actualResult = calculator.add(2, 3);

        assertEquals(5, actualResult);
    }

    @Test
    @DisplayName("Test subtract method")
    void testSubtract() {
        int actualResult = calculator.subtract(5, 3);

        assertEquals(2, actualResult);
    }

    @Test
    @DisplayName("Test multiply method")
    void testMultiply() {
        int actualResult = calculator.multiply(2, 3);

        assertEquals(6, actualResult);
    }

    @Test
    @DisplayName("Test divide method")
    void testDivide() {
        int actualResult = calculator.divide(6, 3);

        assertEquals(2, actualResult);
    }

    @Test
    @DisplayName("Test divide method by zero")
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0));

        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
