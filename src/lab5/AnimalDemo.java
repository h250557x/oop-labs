package lab5;
// EXPLAIN: The superclass defines the common behavior (sound)
class Animal {
    public void sound() {
        System.out.println("Some generic animal sound");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meow");
    }
}

class Cow extends Animal {
    @Override
    public void sound() {
        System.out.println("Moo");
    }
}

class Duck extends Animal {
    @Override
    public void sound() {
        System.out.println("Quack");
    }
}

public class AnimalDemo {
    public static void main(String[] args) {
        // EXPLAIN: Upcasting -> An Animal array holds different subclass objects.
        Animal[] animals = { new Cat(), new Cow(), new Duck() };

        // EXPLAIN: Run-time polymorphism. The JVM calls the sound() method of the
        // ACTUAL object (Cat, Cow, or Duck) at runtime, not the declared type (Animal).
        for (Animal a : animals) {
            a.sound();
        }
    }
}