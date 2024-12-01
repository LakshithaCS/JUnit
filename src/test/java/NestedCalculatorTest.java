import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedCalculatorTest {

    Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @Nested
    class AdditionTests {
        @Test
        void testAddPositiveNumbers() {
            int actualResult = calculator.add(2, 3);
            assertEquals(5, actualResult);
        }

        @Test
        void testAddNegativeNumbers() {
            int actualResult = calculator.add(-2, -3);
            assertEquals(-5, actualResult);
        }
    }

    @Nested
    class SubtractionTests {
        @Test
        void testSubtractPositiveNumbers() {
            int actualResult = calculator.subtract(5, 3);
            assertEquals(2, actualResult);
        }

        @Test
        void testSubtractNegativeNumbers() {
            int actualResult = calculator.subtract(-5, -3);
            assertEquals(-2, actualResult);
        }

        @Nested
        class CornerCases {
            @Test
            void testSubtractZeroFromPositiveNumber() {
                int actualResult = calculator.subtract(5, 0);
                assertEquals(5, actualResult);
            }

            @Test
            void testSubtractZeroFromNegativeNumber() {
                int actualResult = calculator.subtract(-5, 0);
                assertEquals(-5, actualResult);
            }
        }
    }
}
