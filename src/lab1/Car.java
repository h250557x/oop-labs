package lab1;
public class Car {
    // EXPLAIN: fields (state) for the car
    String brand;
    int year;
    double mileage;

    // EXPLAIN: method to display the car's details
    void display() {
        System.out.println("Brand: " + brand + ", Year: " + year + ", Mileage: " + mileage);
    }

    // EXPLAIN: Exercise 2 - returns true if the car is more than 25 years old
    boolean isAntique() {
        // Assuming the current year is 2026 based on your manual's date
        int currentYear = 2026;
        return (currentYear - year) > 25;
    }

    public static void main(String[] args) {
        // Create three cars and print them
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.year = 2010;
        car1.mileage = 150000;

        Car car2 = new Car();
        car2.brand = "Ford";
        car2.year = 1995; // This is more than 25 years old
        car2.mileage = 250000;

        Car car3 = new Car();
        car3.brand = "Honda";
        car3.year = 2022;
        car3.mileage = 15000;

        // Print them
        car1.display();
        System.out.println("Is Antique? " + car1.isAntique());

        car2.display();
        System.out.println("Is Antique? " + car2.isAntique());

        car3.display();
        System.out.println("Is Antique? " + car3.isAntique());
    }
}