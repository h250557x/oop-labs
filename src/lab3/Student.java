package lab3;
public class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        setName(name);
        setMarks(marks); // EXPLAIN: Reusing validation logic from the setter
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name.trim();
    }

    public double getMarks() { return marks; }

    public void setMarks(double marks) {
        // EXPLAIN: Enforcing the class invariant (0 to 100) in the setter
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }

    // EXPLAIN: getGrade() calculates the grade on the fly. It is NOT stored in a field.
    public char getGrade() {
        if (marks >= 80) return 'A';
        if (marks >= 70) return 'B';
        if (marks >= 60) return 'C';
        if (marks >= 50) return 'D';
        return 'F';
    }

    public static void main(String[] args) {
        Student s1 = new Student("Tinashe", 85.5);
        System.out.println(s1.getName() + " scored " + s1.getMarks() + " -> Grade: " + s1.getGrade());

        // Test validation
        try {
            Student s2 = new Student("Rudo", 105);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}