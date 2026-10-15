package lab1;
public class ReferencePrediction {
    public static void main(String[] args) {
        // Create the first Rectangle
        Rectangle r1 = new Rectangle();
        r1.width = 5.0;
        r1.height = 10.0;

        // EXPLAIN: r2 is assigned the SAME memory address as r1.
        // They are now aliases for the exact same object.
        Rectangle r2 = r1;

        // EXPLAIN: Changing r2 changes the single object that both r1 and r2 point to.
        r2.width = 20.0;

        // EXPLAIN: Because r1 and r2 point to the same object, r1.width is also changed.
        System.out.println("r1.width: " + r1.width);
    }
}