package lab6;
abstract class Account {
    protected double balance;
    protected String accountNumber;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // EXPLAIN: Concrete method -> shared behavior for ALL accounts
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited %.2f. New balance: %.2f%n", amount, balance);
        }
    }

    // EXPLAIN: Abstract method -> forces each subclass to define its own fee logic
    public abstract void monthlyFee();
}

class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void monthlyFee() {
        // Savings accounts typically earn interest, so no monthly fee
        System.out.println("Savings Account: No monthly fee. Balance: " + balance);
    }
}

class CurrentAccount extends Account {
    private final double fee = 15.0;

    public CurrentAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void monthlyFee() {
        balance -= fee;
        System.out.printf("Current Account: Monthly fee of %.2f deducted. New balance: %.2f%n", fee, balance);
    }
}

public class AccountDemo {
    public static void main(String[] args) {
        Account savings = new SavingsAccount("SAV-001", 1000);
        Account current = new CurrentAccount("CUR-001", 500);

        savings.deposit(500);  // Shared concrete method
        savings.monthlyFee();  // Savings-specific logic

        System.out.println();

        current.deposit(200);  // Shared concrete method
        current.monthlyFee();  // Current-specific logic
    }
}