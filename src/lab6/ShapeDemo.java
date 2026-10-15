package lab6;
// EXPLAIN: Abstract class -> cannot be instantiated. It defines a template for subclasses.
abstract class Shape {
    // Abstract methods -> no body. Subclasses MUST provide the implementation.
    abstract double area();
    abstract double perimeter();
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) { this.radius = radius; }

    @Override
    double area() { return Math.PI * radius * radius; }

    @Override
    double perimeter() { return 2 * Math.PI * radius; }
}

class Rectangle extends Shape {
    protected double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() { return width * height; }

    @Override
    double perimeter() { return 2 * (width + height); }
}

class Square extends Rectangle {
    // EXPLAIN: A Square IS-A Rectangle. We just enforce equal width and height.
    public Square(double side) {
        super(side, side);
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        // EXPLAIN: Polymorphic array holding abstract Shape references.
        Shape[] shapes = { new Circle(5), new Rectangle(4, 6), new Square(4) };

        for (Shape s : shapes) {
            System.out.printf("%-10s Area: %.2f | Perimeter: %.2f%n",
                    s.getClass().getSimpleName(), s.area(), s.perimeter());
        }
    }
}
