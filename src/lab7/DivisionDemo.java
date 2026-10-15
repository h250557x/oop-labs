package lab7;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first integer: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the second integer: ");
            int num2 = scanner.nextInt();

            // EXPLAIN: This line can throw an ArithmeticException if num2 is 0.
            int result = num1 / num2;
            System.out.println("Result: " + num1 + " / " + num2 + " = " + result);

        } catch (InputMismatchException e) {
            // EXPLAIN: Catches non-numeric input (e.g. typing "abc" instead of a number)
            System.out.println("Error: Please enter valid integers only.");
        } catch (ArithmeticException e) {
            // EXPLAIN: Catches division by zero
            System.out.println("Error: Cannot divide by zero!");
        } finally {
            // EXPLAIN: The finally block always runs, even if an exception is caught.
            scanner.close();
            System.out.println("Program finished.");
        }
    }
}