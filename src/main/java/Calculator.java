public class Calculator {

    //method for adding two numbers
    public int add(int a, int b) {
        return a + b;
    }

    //method for subtracting two numbers
    public int subtract(int a, int b) {
        return a - b;
    }

    //method for multiplying two numbers
    public int multiply(int a, int b) {
        return a * b;
    }

    //method for dividing two numbers
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
