package lab1;
public class Rectangle {
    double width;
    double height;

    // Method to calculate area
    double area() {
        return width * height;
    }

    // Method to calculate perimeter
    double perimeter() {
        return 2 * (width + height);
    }

    public static void main(String[] args) {
        // Create an array of 5 rectangles
        Rectangle[] rectangles = new Rectangle[5];

        // Initialize the rectangles with different sizes
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = new Rectangle();
            rectangles[i].width = (i + 1) * 2.0;  // Widths: 2.0, 4.0, 6.0, 8.0, 10.0
            rectangles[i].height = (i + 1) * 3.0; // Heights: 3.0, 6.0, 9.0, 12.0, 15.0
        }

        // Find the one with the largest area
        Rectangle largest = rectangles[0];
        for (int i = 1; i < rectangles.length; i++) {
            if (rectangles[i].area() > largest.area()) {
                largest = rectangles[i];
            }
        }

        // Print the largest rectangle's details
        System.out.println("The rectangle with the largest area is:");
        System.out.println("Width: " + largest.width);
        System.out.println("Height: " + largest.height);
        System.out.println("Area: " + largest.area());
    }
}