package lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveEvenDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        System.out.println("Original list: " + numbers);

        // EXPLAIN: Predicate<T> -> Functional interface that takes one argument and returns boolean.
        // Here, it returns true if the number is even.
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // EXPLAIN: removeIf() removes all elements that satisfy the Predicate.
        numbers.removeIf(isEven);

        System.out.println("List after removing evens: " + numbers);
    }
}
