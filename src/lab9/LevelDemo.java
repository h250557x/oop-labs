package lab9;
public class LevelDemo {
    // EXPLAIN: Enum -> A fixed set of constants. Type-safe and used in switch statements.
    enum Level {
        LOW, MEDIUM, HIGH
    }

    public static void main(String[] args) {
        Level currentLevel = Level.MEDIUM;

        // EXPLAIN: Switch expression (Java 14+) -> Compiler checks all cases are covered
        String advice = switch (currentLevel) {
            case LOW -> "You need to focus more and put in more effort.";
            case MEDIUM -> "You are doing okay, but there is room for improvement.";
            case HIGH -> "Excellent work! Keep it up!";
        };

        System.out.println("Level: " + currentLevel);
        System.out.println("Advice: " + advice);

        // Test the other levels
        System.out.println();
        for (Level l : Level.values()) {
            System.out.println(l + " -> " + getAdvice(l));
        }
    }

    // Traditional switch statement for comparison
    public static String getAdvice(Level level) {
        switch (level) {
            case LOW: return "Work harder!";
            case MEDIUM: return "Keep pushing!";
            case HIGH: return "Great job!";
            default: return "Unknown level";
        }
    }
}
