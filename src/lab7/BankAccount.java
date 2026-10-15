package lab7;
public class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    // EXPLAIN: Instead of returning false, this method now throws a custom exception.
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            // EXPLAIN: Creating and throwing the custom checked exception with useful info
            throw new InsufficientFundsException(
                    "Cannot withdraw " + amount + "; balance is " + balance,
                    amount - balance
            );
        }
        balance -= amount;
    }

    public double getBalance() { return balance; }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", 100.0);

        try {
            acc.withdraw(60.0);
            System.out.println("Balance after withdrawal: " + acc.getBalance());

            acc.withdraw(60.0); // This will fail
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Short by: " + e.getShortfall());
        }
    }
}