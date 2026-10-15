package lab3;
// EXPLAIN: 'final' class -> Cannot be subclassed. This prevents a subclass from
// overriding methods and changing the immutable behavior.
public final class ImmutablePerson {

    // EXPLAIN: 'final' fields -> The values are assigned once in the constructor
    // and cannot be changed afterwards.
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // EXPLAIN: Only getters, NO setters. Once created, the object's state is locked.
    public String getName() { return name; }
    public int getAge() { return age; }

    public static void main(String[] args) {
        ImmutablePerson p = new ImmutablePerson("Tinashe", 25);
        System.out.println(p.getName() + " is " + p.getAge() + " years old.");

        // p.name = "Rudo"; // COMPILE ERROR: Cannot assign a value to a final field
    }
}