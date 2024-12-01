package math;

public class MathUtil {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public boolean isWeekDay(Day day) {
        return day != Day.SATURDAY && day != Day.SUNDAY;
    }

    public int getSquareNumber(int n) {
        return n * n;
    }

    public int getCubeNumber(int n) {
        return n * n * n;
    }

    public int getFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be greater than or equal to 0");
        }
        if (n == 0) {
            return 1;
        }
        return n * getFactorial(n - 1);
    }
}
