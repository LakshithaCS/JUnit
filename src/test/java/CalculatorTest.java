import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator operation tests")
class CalculatorTest {

    @Test
    @DisplayName("Test add method")
    void testAdd() {
        Calculator calculator = new Calculator();
        int actualResult = calculator.add(2, 3);

        assertEquals(5, actualResult);
    }

    @Test
    @DisplayName("Test subtract method")
    void testSubtract() {
        Calculator calculator = new Calculator();
        int actualResult = calculator.subtract(5, 3);

        assertEquals(2, actualResult);
    }

    @Test
    @DisplayName("Test multiply method")
    void testMultiply() {
        Calculator calculator = new Calculator();
        int actualResult = calculator.multiply(2, 3);

        assertEquals(6, actualResult);
    }

    @Test
    @DisplayName("Test divide method")
    void testDivide() {
        Calculator calculator = new Calculator();
        int actualResult = calculator.divide(6, 3);

        assertEquals(2, actualResult);
    }

    @Test
    @DisplayName("Test divide method by zero")
    void testDivideByZero() {
        Calculator calculator = new Calculator();
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0));

        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    @DisplayName("Test divide method by zero")
    @Disabled
    void testDivideByZero_disabled() {
        Calculator calculator = new Calculator();
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0));

        assertEquals("Cannot divide by zero ******", exception.getMessage());
    }
}