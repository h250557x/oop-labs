package lab5;
class Parent {
    // EXPLAIN: Fields are NOT polymorphic. They are resolved at compile time based on the reference type.
    public String name = "Parent Field";

    // EXPLAIN: Methods ARE polymorphic. They are resolved at runtime based on the object type.
    public String getName() {
        return "Parent Method";
    }
}

class Child extends Parent {
    // EXPLAIN: This HIDES the parent's field, it does not override it.
    public String name = "Child Field";

    @Override
    public String getName() {
        return "Child Method";
    }
}

public class FieldVsMethod {
    public static void main(String[] args) {
        // Upcast: A Parent reference pointing to a Child object
        Parent p = new Child();

        // EXPLAIN: Field access follows the DECLARED type (Parent).
        // Therefore, it prints "Parent Field".
        System.out.println("Field access: " + p.name);

        // EXPLAIN: Method access follows the ACTUAL object type (Child) due to dynamic dispatch.
        // Therefore, it prints "Child Method".
        System.out.println("Method access: " + p.getName());
    }
}