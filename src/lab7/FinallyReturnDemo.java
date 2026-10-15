package lab7;
public class FinallyReturnDemo {

    public static int testMethod() {
        try {
            System.out.println("Inside try block. About to return 10.");
            return 10; // EXPLAIN: The return statement is evaluated, but not executed yet.
        } finally {
            // EXPLAIN: The finally block ALWAYS runs before the method actually returns.
            System.out.println("Inside finally block. This runs before the actual return.");
        }
    }

    public static void main(String[] args) {
        int result = testMethod();
        System.out.println("Method returned: " + result);
    }
}