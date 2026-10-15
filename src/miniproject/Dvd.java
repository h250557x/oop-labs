package miniproject;

import java.time.LocalDate;

public class Dvd extends LibraryItem {
    private final int runtimeMinutes;
    private static final int LOAN_DAYS = 3;

    public Dvd(String id, String title, int runtimeMinutes) {
        super(id, title);
        this.runtimeMinutes = runtimeMinutes;
    }

    @Override
    public int loanPeriodDays() {
        return LOAN_DAYS;
    }

    @Override
    public void borrow(Member member) throws ItemNotAvailableException, MemberLimitExceededException {
        if (!isAvailable()) {
            throw new ItemNotAvailableException("DVD already borrowed: " + getTitle());
        }
        if (member.getLoans().size() >= 3) {
            throw new MemberLimitExceededException(
                    "Member " + member.getName() + " has reached the maximum of 3 loans."
            );
        }
        setAvailable(false);
        Loan loan = new Loan(member, this, LocalDate.now(), LOAN_DAYS);
        member.addLoan(loan);
        System.out.println("DVD borrowed: '" + getTitle() + "' by " + member.getName());
    }

    @Override
    public void giveBack(Member member) {
        setAvailable(true);
        System.out.println("DVD returned: '" + getTitle() + "' by " + member.getName());
    }

    public int getRuntimeMinutes() { return runtimeMinutes; }
}