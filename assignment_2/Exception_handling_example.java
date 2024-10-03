public class Exception_handling_example {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: Division by zero.");
        }
    }

    public static int divide(int a, int b) {
        return a / b;  // This will throw an ArithmeticException
    }
}
