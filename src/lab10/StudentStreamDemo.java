package lab10;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

record Student(String name, double marks) { }

public class StudentStreamDemo {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Tinashe", 85.0),
                new Student("Rudo", 92.5),
                new Student("Farai", 65.0),
                new Student("Nyasha", 78.0),
                new Student("Chipo", 90.0)
        );

        // EXPLAIN: Terminal operation average() returns OptionalDouble
        double average = students.stream()
                .mapToDouble(Student::marks)
                .average()
                .orElse(0.0);

        System.out.printf("Class Average: %.2f%n", average);

        // EXPLAIN: Stream pipeline -> filter (above average) -> map (get name) -> sorted -> collect
        List<String> topStudents = students.stream()
                .filter(s -> s.marks() > average)      // Intermediate operation
                .map(Student::name)                    // Intermediate operation (method reference)
                .sorted()                              // Intermediate operation
                .collect(Collectors.toList());         // Terminal operation

        System.out.println("Students above average (sorted alphabetically): " + topStudents);
    }
}
