package lab5;
public class OverloadDemo {
    // EXPLAIN: Compile-time polymorphism (Method Overloading). Same name, different parameters.

    public void print(int i) {
        System.out.println("Printing int: " + i);
    }

    public void print(double d) {
        System.out.println("Printing double: " + d);
    }

    public void print(String s) {
        System.out.println("Printing String: " + s);
    }

    public void print(int[] arr) {
        System.out.print("Printing int array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        OverloadDemo demo = new OverloadDemo();

        // The compiler decides which method to call based on the argument type
        demo.print(10);
        demo.print(3.14);
        demo.print("Hello Java");
        demo.print(new int[]{1, 2, 3, 4, 5});
    }
}