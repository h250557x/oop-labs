package lab9;
// EXPLAIN: A record is a compact, immutable data carrier. Java automatically generates:
// constructor, accessor methods (name(), age()), equals(), hashCode() and toString().
record Student(String name, int age) { }

public class RecordDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Tinashe", 20);
        Student s2 = new Student("Tinashe", 20);
        Student s3 = new Student("Rudo", 22);

        // EXPLAIN: toString() is auto-generated
        System.out.println("Student 1: " + s1);
        System.out.println("Student 2: " + s2);
        System.out.println("Student 3: " + s3);

        // EXPLAIN: equals() is auto-generated -> compares by value
        System.out.println("\ns1.equals(s2): " + s1.equals(s2)); // true
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // false

        // EXPLAIN: Accessor methods are auto-generated (note: no "get" prefix)
        System.out.println("\nName: " + s1.name()); // read a component
        System.out.println("Age: " + s1.age());
    }
}