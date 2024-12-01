package math;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void isEven(int number) {
        MathUtil mathUtil = new MathUtil();
        assertFalse(mathUtil.isEven(number));
    }

    @ParameterizedTest
    @EnumSource(value = Day.class, names = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"})
    void isWeekDay(Day day) {
        MathUtil mathUtil = new MathUtil();
        assertTrue(mathUtil.isWeekDay(day));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 4",
            "3, 9",
            "4, 16",
            "5, 25"})
    void getSquareNumber(int n, int expected) {
        MathUtil mathUtil = new MathUtil();
        assertEquals(expected, mathUtil.getSquareNumber(n));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void getCubeNumber(int n, int expected) {
        MathUtil mathUtil = new MathUtil();
        assertEquals(expected, mathUtil.getCubeNumber(n));
    }

    @ParameterizedTest
    @MethodSource("math.MathUtilTest#factorialProvider")
    void getFactorial(int n, int expected) {
        MathUtil mathUtil = new MathUtil();
        assertEquals(expected, mathUtil.getFactorial(n));
    }

    @ParameterizedTest
    @ArgumentsSource(FactorialArgumentsProvider.class)
    void getFactorial_argument_provider(int n, int expected) {
        MathUtil mathUtil = new MathUtil();
        assertEquals(expected, mathUtil.getFactorial(n));
    }

    static Stream<Arguments> factorialProvider() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 6),
                Arguments.of(4, 24),
                Arguments.of(5, 120)
        );
    }
}