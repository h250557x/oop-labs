package lab2;
public class Employee {
    private final int employeeId;
    private String name;
    private double salary;

    // EXPLAIN: Static counter to track the next available ID
    private static int nextId = 100;

    // Constructor 1: Full initialization
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        // EXPLAIN: Auto-incrementing ID. Assigned exactly once.
        this.employeeId = nextId++;
    }

    // Constructor 2: Constructor chaining (Defaults salary to 0.0)
    public Employee(String name) {
        this(name, 0.0);
    }

    // Constructor 3: No-argument constructor
    public Employee() {
        this("Unknown", 0.0);
    }

    // EXPLAIN: Copy constructor creates an independent object with the same values
    public Employee(Employee other) {
        // Note: This new object gets a NEW unique employeeId because of the constructor chain
        this(other.name, other.salary);
    }

    public void display() {
        System.out.printf("ID: %d | Name: %s | Salary: $%.2f%n", employeeId, name, salary);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Tinaye", 50000);
        Employee e2 = new Employee("Witney"); // Defaults salary
        Employee e3 = new Employee();      // Defaults everything

        // Create a copy of e1
        Employee e4 = new Employee(e1);

        e1.display();
        e2.display();
        e3.display();
        e4.display(); // Should have same name/salary as e1, but a new ID
    }
}
