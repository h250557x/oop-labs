package lab6;
// EXPLAIN: Interface -> a pure contract. It defines WHAT can be done, not HOW.
interface Flyable {
    void fly();
}

// EXPLAIN: Bird has no relationship with Aeroplane, but both can fly.
class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird flaps its wings and flies.");
    }
}

class Aeroplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Aeroplane uses jet engines to fly.");
    }
}

public class FlyableDemo {
    public static void main(String[] args) {
        // EXPLAIN: Program to an interface, not an implementation.
        Flyable[] flyingObjects = { new Bird(), new Aeroplane() };

        for (Flyable f : flyingObjects) {
            f.fly(); // Dynamic dispatch determines which fly() to call
        }
    }
}
