package lab4;

// ============================================================
// Lab 4 - Exercise 4: Constructor Compilation Error
// ============================================================
// This program demonstrates why a subclass fails to compile
// when the superclass has no no-argument constructor.
//
// WHY THIS FAILS:
//   When a subclass is created, Java automatically inserts
//   a call to super() (the no-argument constructor of the parent)
//   as the first statement of the subclass's constructor.
//
//   But Animal only has Animal(String name) — there is NO
//   no-argument constructor.
//
//   Therefore, the compiler cannot insert super(), and the
//   program fails to compile with:
//     "constructor Animal in class Animal cannot be applied
//      to given types; required: String; found: no arguments"
//
// HOW TO FIX:
//   Add an explicit call: super(name);
// ============================================================

class Animal {
    private String name;

    // Only constructor: requires a String argument
    public Animal(String name) {
        this.name = name;
    }
}

// This class WILL NOT COMPILE because the compiler tries to
// insert an implicit super() call, but Animal has no no-arg
// constructor.
//
// class Dog extends Animal {
//     // No constructor here — compiler tries to insert super()
// }

// The corrected version — explicitly calls super(name)
class Dog extends Animal {
    public Dog(String name) {
        super(name); // Explicit call to the parent constructor
    }
}

public class AnimalDemo {
    public static void main(String[] args) {
        Dog d = new Dog("Rex");
        System.out.println("Dog created successfully with explicit super(name).");
    }
}