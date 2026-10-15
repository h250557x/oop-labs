package lab3;
public final class Temperature {
    // EXPLAIN: Internal storage is always in Kelvin. This is our "canonical" unit.
    private final double kelvin;

    public Temperature(double kelvin) {
        // EXPLAIN: Absolute zero is 0 Kelvin. Rejecting values below this prevents an invalid state.
        if (kelvin < 0) {
            throw new IllegalArgumentException("Temperature cannot be below absolute zero (0 K)");
        }
        this.kelvin = kelvin;
    }

    // Static factory methods for convenience (from Lab 2)
    public static Temperature fromCelsius(double celsius) {
        return new Temperature(celsius + 273.15);
    }

    public static Temperature fromFahrenheit(double fahrenheit) {
        return new Temperature((fahrenheit - 32) * 5.0 / 9.0 + 273.15);
    }

    // EXPLAIN: The getter converts from the internal Kelvin unit to the requested unit on the fly.
    public double getCelsius() {
        return kelvin - 273.15;
    }

    public double getFahrenheit() {
        return (kelvin - 273.15) * 9.0 / 5.0 + 32;
    }

    public double getKelvin() {
        return kelvin;
    }

    public static void main(String[] args) {
        Temperature t1 = Temperature.fromCelsius(25.0);

        System.out.printf("Celsius: %.2f%n", t1.getCelsius());
        System.out.printf("Fahrenheit: %.2f%n", t1.getFahrenheit());
        System.out.printf("Kelvin: %.2f%n", t1.getKelvin());

        // Test rejection of absolute zero
        try {
            Temperature t2 = Temperature.fromCelsius(-300.0);
        } catch (IllegalArgumentException e) {
            System.out.println("\nRejected: " + e.getMessage());
        }
    }
}