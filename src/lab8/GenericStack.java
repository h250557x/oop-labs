package lab8;
import java.util.ArrayList;
import java.util.List;

// EXPLAIN: <T> is a generic type parameter. It can be replaced by any reference type (String, Integer, etc.)
public class GenericStack<T> {
    // EXPLAIN: Composition -> The Stack class HAS-A List internally.
    private final List<T> elements = new ArrayList<>();

    public void push(T item) {
        elements.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public static void main(String[] args) {
        // EXPLAIN: Using the generic Stack with String
        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("First");
        stringStack.push("Second");
        stringStack.push("Third");

        System.out.println("Top of stack (peek): " + stringStack.peek());
        System.out.println("Popped: " + stringStack.pop());
        System.out.println("Popped: " + stringStack.pop());
        System.out.println("Stack size now: " + stringStack.size());
    }
}
