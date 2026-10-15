package lab3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;

    // EXPLAIN: Private list to hold transaction history
    private final List<String> transactionHistory = new ArrayList<>();

    public BankAccount(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        setOwnerName(ownerName);
        this.balance = openingBalance;
        transactionHistory.add("Account opened with balance: " + openingBalance);
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName()   { return ownerName; }
    public double getBalance()   { return balance; }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name required");
        }
        this.ownerName = ownerName.trim();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            transactionHistory.add("Failed withdrawal attempt: " + amount);
            return false;
        }
        balance -= amount;
        transactionHistory.add("Withdrew: " + amount);
        return true;
    }

    // EXPLAIN: Returning an unmodifiable copy prevents the caller from altering our internal list.
    // This is the "defensive-copy trap" solution from Program 3.2.
    public List<String> getTransactionHistory() {
        return Collections.unmodifiableList(transactionHistory);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500.00);
        acc.deposit(250.00);
        acc.withdraw(100.00);
        acc.withdraw(5000.00); // Should fail

        System.out.println("Account: " + acc.getAccountNumber() + " | Balance: " + acc.getBalance());
        System.out.println("Transaction History:");
        for (String log : acc.getTransactionHistory()) {
            System.out.println("  - " + log);
        }

        // Test the defensive copy
        try {
            acc.getTransactionHistory().clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("\nSafe getter blocked modification of history.");
        }
    }
}