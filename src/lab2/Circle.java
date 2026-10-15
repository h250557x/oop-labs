package lab2;
public class Circle {
    private double radius;

    // EXPLAIN: Static field -> ONE copy shared by all Circle objects
    private static int count = 0;

    // Constructor 1: Takes radius
    public Circle(double radius) {
        this.radius = radius;
        count++; // Increment shared counter
    }

    // Constructor 2: No-argument constructor defaults radius to 1.0
    public Circle() {
        // EXPLAIN: Constructor chaining with this(...) must be the first statement
        this(1.0);
    }

    // EXPLAIN: Static method -> belongs to the class, not the object. No 'this'.
    public static int getCount() {
        return count;
    }

    public void display() {
        System.out.println("Circle radius: " + radius);
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle(); // Uses default 1.0
        Circle c3 = new Circle(2.5);

        c1.display();
        c2.display();
        c3.display();

        // EXPLAIN: Accessing the static counter via the class name
        System.out.println("Total circles created: " + Circle.getCount());
    }
}