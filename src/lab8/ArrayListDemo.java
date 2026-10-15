package lab8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        // EXPLAIN: Programming to the interface (List) but using ArrayList implementation.
        List<Integer> numbers = new ArrayList<>();

        // Add 10 integers
        for (int i = 1; i <= 10; i++) {
            numbers.add(i * 5); // Adds 5, 10, 15, ... 50
        }

        // Calculate sum
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        // Find maximum
        int max = Collections.max(numbers);

        // Print results
        System.out.println("List: " + numbers);
        System.out.println("Sum: " + sum);
        System.out.println("Maximum: " + max);

        // EXPLAIN: Reverse the list in-place
        Collections.reverse(numbers);
        System.out.println("Reversed List: " + numbers);
    }
}