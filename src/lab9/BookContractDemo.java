package lab9;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book {
    private final String isbn;
    private final String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }

    // EXPLAIN: Equality is based ONLY on ISBN (the unique identifier)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(isbn, book.isbn);
    }

    // EXPLAIN: Objects that are equal MUST produce the same hashCode.
    // We use the same field (isbn) used in equals().
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return title + " (ISBN: " + isbn + ")";
    }
}

public class BookContractDemo {
    public static void main(String[] args) {
        Book b1 = new Book("978-0134685991", "Effective Java");
        Book b2 = new Book("978-0134685991", "Effective Java"); // Same ISBN -> duplicate
        Book b3 = new Book("978-0132350884", "Clean Code");

        // EXPLAIN: HashSet uses hashCode() to find the bucket, then equals() to check for duplicates.
        Set<Book> library = new HashSet<>();
        library.add(b1);
        library.add(b2); // Should be rejected as a duplicate
        library.add(b3);

        System.out.println("Set size (expected 2): " + library.size());
        System.out.println("Books in set:");
        for (Book b : library) {
            System.out.println("  - " + b);
        }
    }
}