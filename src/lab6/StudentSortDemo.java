package lab6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }

    // EXPLAIN: Natural ordering -> sorted alphabetically by name (A-Z)
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }
}

public class StudentSortDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Blessing", 95));
        students.add(new Student("Anesu", 70));
        students.add(new Student("Chenai", 82));

        // Sort using Comparable (by name)
        Collections.sort(students);
        System.out.println("Sorted by name (Comparable):");
        System.out.println(students);

        // EXPLAIN: Comparator -> Custom sorting logic that lives OUTSIDE the class.
        // Sort by marks descending (highest first)
        Comparator<Student> byMarksDescending = (s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks());

        students.sort(byMarksDescending);
        System.out.println("\nSorted by marks (Comparator, descending):");
        System.out.println(students);
    }
}
