package miniproject;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String id;
    private final String name;
    private final List<Loan> loans = new ArrayList<>();

    public Member(String id, String name) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Member ID required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Member name required");
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Loan> getLoans() { return loans; }

    public void addLoan(Loan loan) { loans.add(loan); }
    public void removeLoan(Loan loan) { loans.remove(loan); }

    @Override
    public String toString() {
        return "Member[id=" + id + ", name=" + name + ", activeLoans=" + loans.size() + "]";
    }
}