package lab5;
// Base Employee class (from Lab 4)
class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculatePay() {
        return baseSalary;
    }

    public String getName() { return name; }
}

// Manager subclass
class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculatePay() {
        return baseSalary + bonus;
    }
}

// Developer subclass
class Developer extends Employee {
    private int overtimeHours;
    private static final double OVERTIME_RATE = 25.0;

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculatePay() {
        return baseSalary + (overtimeHours * OVERTIME_RATE);
    }
}

// NEW: Intern subclass
class Intern extends Employee {
    public Intern(String name, double baseSalary) {
        super(name, baseSalary);
    }
    // EXPLAIN: No need to override calculatePay() because interns just get baseSalary.
}

public class PayrollDemo {
    public static void main(String[] args) {
        // EXPLAIN: Polymorphic array holding different types of employees
        Employee[] staff = {
                new Employee("Kudzai", 2000),
                new Manager("Nyasha", 3500, 800),
                new Developer("Tatenda", 3000, 10),
                new Intern("Rudo", 500) // New subclass added without breaking the loop
        };

        double totalPayroll = 0;

        System.out.println("--- Processing Payroll ---");
        // EXPLAIN: The payroll loop does NOT need to change to support the new Intern class.
        // This is the "Open/Closed Principle" in action.
        for (Employee e : staff) {
            double pay = e.calculatePay();
            System.out.printf("%-10s earns %.2f%n", e.getName(), pay);
            totalPayroll += pay;
        }

        System.out.printf("%nTotal Payroll: %.2f%n", totalPayroll);
    }
}