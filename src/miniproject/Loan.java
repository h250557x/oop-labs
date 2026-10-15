package miniproject;

import java.time.LocalDate;

public class Loan {
    private final Member member;
    private final LibraryItem item;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;

    public Loan(Member member, LibraryItem item, LocalDate borrowDate, int loanDays) {
        this.member = member;
        this.item = item;
        this.borrowDate = borrowDate;
        this.dueDate = borrowDate.plusDays(loanDays);
    }

    public Member getMember() { return member; }
    public LibraryItem getItem() { return item; }
    public LocalDate getDueDate() { return dueDate; }

    public boolean isOverdue(LocalDate today) {
        return today.isAfter(dueDate);
    }

    @Override
    public String toString() {
        return "Loan[item=" + item.getTitle() + ", member=" + member.getName() + ", due=" + dueDate + "]";
    }
}