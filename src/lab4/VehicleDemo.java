package lab4;
class Vehicle {
    public Vehicle() {
        System.out.println("Vehicle constructor");
    }
}

class Car extends Vehicle {
    public Car() {
        // EXPLAIN: Implicit super() is called here automatically, running Vehicle's constructor first.
        System.out.println("Car constructor");
    }
}

class ElectricCar extends Car {
    public ElectricCar() {
        // EXPLAIN: Implicit super() runs Car's constructor, which in turn runs Vehicle's.
        System.out.println("ElectricCar constructor");
    }

    public static void main(String[] args) {
        System.out.println("--- Creating an ElectricCar ---");
        new ElectricCar();
    }
}
