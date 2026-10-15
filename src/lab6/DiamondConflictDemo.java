package lab6;
interface InterfaceA {
    default void hello() {
        System.out.println("Hello from Interface A");
    }
}

interface InterfaceB {
    default void hello() {
        System.out.println("Hello from Interface B");
    }
}

// EXPLAIN: When a class implements two interfaces that have the SAME default method,
// the compiler forces us to OVERRIDE the method to resolve the ambiguity.
// If we don't, it is a compile-time error.
class MyClass implements InterfaceA, InterfaceB {

    // EXPLAIN: We must explicitly choose which one to call using InterfaceName.super.methodName()
    @Override
    public void hello() {
        InterfaceA.super.hello(); // Calls InterfaceA's version
        InterfaceB.super.hello(); // Calls InterfaceB's version
        System.out.println("Hello from MyClass");
    }
}

public class DiamondConflictDemo {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.hello();
    }
}