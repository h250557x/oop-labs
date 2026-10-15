package lab9;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements Iterable<T> {

    // EXPLAIN: Static nested class -> Does not need an outer instance.
    // Used as a helper "structure" for the data.
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private int size;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // EXPLAIN: Inner class -> Has a hidden reference to the outer CustomLinkedList instance.
    // It can access the outer's private 'head' and 'size'.
    public class LinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    // EXPLAIN: Iterable interface allows the for-each loop to work
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public static void main(String[] args) {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("First");
        list.add("Second");
        list.add("Third");

        System.out.println("Iterating with for-each loop:");
        for (String item : list) {
            System.out.println("  - " + item);
        }
    }
}