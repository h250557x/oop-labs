package lab7;
// EXPLAIN: Extending Exception makes this a CHECKED exception.
// Callers MUST handle it or declare it with 'throws'.
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message); // Pass the message to the parent Exception class
    }
}