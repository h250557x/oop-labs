package lab4;
public class Student extends Person { // EXPLAIN: Student IS-A Person
    private String course;

    public Student(String name, int age, String course) {
        // EXPLAIN: super(...) must be the FIRST statement. Runs the parent constructor.
        super(name, age);
        this.course = course;
    }

    // EXPLAIN: Overriding the parent's display() to add Student-specific information
    @Override
    public void display() {
        super.display(); // Reuse the parent's logic
        System.out.println("Course: " + course);
    }

    public static void main(String[] args) {
        Student s = new Student("Tinashe", 20, "Computer Science");
        Teacher t = new Teacher("Mr. Smith", 45, "Mathematics");

        System.out.println("--- Student Details ---");
        s.display();

        System.out.println("\n--- Teacher Details ---");
        t.display(); // Inherited method works for Teacher too!
    }
}