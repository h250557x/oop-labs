package lab2;
public class BlockOrder {
    // EXPLAIN: Static initializer blocks run ONCE when the class is first loaded.
    // They run in the order they are written, top to bottom.
    static {
        System.out.println("Static block 1");
    }

    static {
        System.out.println("Static block 2");
    }

    // EXPLAIN: Instance initializer blocks run EVERY time an object is created.
    // They run in the order written, BEFORE the constructor body.
    {
        System.out.println("Instance block 1");
    }

    {
        System.out.println("Instance block 2");
    }

    // Constructor
    public BlockOrder() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        System.out.println("--- Creating first object ---");
        new BlockOrder();

        System.out.println("\n--- Creating second object ---");
        new BlockOrder();
    }
}