package lab9;
public enum CoinChangeDemo {
    // EXPLAIN: Enum constants with associated values
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    private final int value;

    // EXPLAIN: Constructor for the enum
    CoinChangeDemo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // EXPLAIN: Static method that uses the enum constants to calculate change
    public static void printFewestCoins(int amount) {
        System.out.println("Fewest coins for " + amount + " cents:");

        // Sort the values in descending order to use the largest coins first (Greedy algorithm)
        CoinChangeDemo[] coins = { QUARTER, DIME, NICKEL, PENNY };

        for (CoinChangeDemo coin : coins) {
            if (amount >= coin.getValue()) {
                int count = amount / coin.getValue();
                amount = amount % coin.getValue();
                System.out.println("  " + coin + " (" + coin.getValue() + "c) x " + count);
            }
        }
    }

    public static void main(String[] args) {
        printFewestCoins(87);
        System.out.println();
        printFewestCoins(30);
    }
}