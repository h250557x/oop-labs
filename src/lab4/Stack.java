package lab4;
import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    // EXPLAIN: Composition ("HAS-A"). The Stack class OWNS an ArrayList.
    // This is better than "extends ArrayList" because a Stack is NOT an ArrayList
    // (it shouldn't inherit methods like get(index) or add(index, element)).
    private final List<T> elements = new ArrayList<>();

    // EXPLAIN: We only expose the methods that are valid for a Stack.
    public void push(T item) {
        elements.add(item); // Add to the end
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        // Remove and return the last item added
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
        Stack<String> stack = new Stack<>();

        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println("Top of stack (peek): " + stack.peek()); // Third
        System.out.println("Popped: " + stack.pop()); // Third
        System.out.println("Popped: " + stack.pop()); // Second
        System.out.println("Stack size now: " + stack.size()); // 1

        // EXPLAIN: We CANNOT do this because Stack does not extend ArrayList.
        // stack.get(0); // COMPILE ERROR: Method not available
    }
}