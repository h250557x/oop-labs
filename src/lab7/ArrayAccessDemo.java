package lab7;
public class ArrayAccessDemo {

    // EXPLAIN: This method is risky. It tries to access an index that may not exist.
    public static void accessElement(int[] arr, int index) {
        try {
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // EXPLAIN: Catches the specific error where the index is outside 0 to length-1.
            System.out.println("Error: Index " + index + " is out of bounds for array of length " + arr.length);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};

        // Valid access
        accessElement(numbers, 1); // Prints 20

        // Invalid access (Index 5 does not exist)
        accessElement(numbers, 5); // Triggers the catch block
    }
}
