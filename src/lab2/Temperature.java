package lab2;
public class Temperature {
    private double celsius;

    // EXPLAIN: Private constructor -> Cannot be called directly from outside.
    // Forces the user to use the named factory methods instead.
    private Temperature(double celsius) {
        this.celsius = celsius;
    }

    // EXPLAIN: Static Factory Method for Celsius
    public static Temperature fromCelsius(double c) {
        return new Temperature(c);
    }

    // EXPLAIN: Static Factory Method for Fahrenheit
    public static Temperature fromFahrenheit(double f) {
        // Convert F to C using standard formula
        double c = (f - 32) * 5.0 / 9.0;
        return new Temperature(c);
    }

    public double getCelsius() {
        return celsius;
    }

    public static void main(String[] args) {
        // EXPLAIN: The code reads clearly. "Temperature from Celsius 25"
        Temperature t1 = Temperature.fromCelsius(25.0);

        // EXPLAIN: The code reads clearly. "Temperature from Fahrenheit 77"
        Temperature t2 = Temperature.fromFahrenheit(77.0);

        System.out.println("Temp 1 in Celsius: " + t1.getCelsius());
        System.out.println("Temp 2 in Celsius: " + t2.getCelsius());
    }
}