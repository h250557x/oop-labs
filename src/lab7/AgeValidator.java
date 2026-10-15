package lab7;
public class AgeValidator {

    // EXPLAIN: 'throws' warns the caller that they must handle this checked exception
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            // EXPLAIN: 'throw' creates and throws the exception object
            throw new InvalidAgeException("Invalid age: " + age + ". Age must be between 0 and 120.");
        }
        System.out.println("Age " + age + " is valid.");
    }

    public static void main(String[] args) {
        try {
            validateAge(25);  // Valid
            validateAge(150); // Invalid -> throws exception
        } catch (InvalidAgeException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
