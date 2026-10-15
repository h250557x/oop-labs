package miniproject;
import java.time.LocalDate;

public class Book extends LibraryItem {
    private final String author;
    private static final int LOAN_DAYS = 14;

    public Book(String id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    @Override
    public int loanPeriodDays() {
        return LOAN_DAYS;
    }

    @Override
    public void borrow(Member member) throws ItemNotAvailableException, MemberLimitExceededException {
        if (!isAvailable()) {
            throw new ItemNotAvailableException("Book already borrowed: " + getTitle());
        }
        if (member.getLoans().size() >= 3) {
            throw new MemberLimitExceededException(
                    "Member " + member.getName() + " has reached the maximum of 3 loans."
            );
        }
        setAvailable(false);
        Loan loan = new Loan(member, this, LocalDate.now(), LOAN_DAYS);
        member.addLoan(loan);
        System.out.println("Book borrowed: '" + getTitle() + "' by " + member.getName());
    }

    @Override
    public void giveBack(Member member) {
        setAvailable(true);
        System.out.println("Book returned: '" + getTitle() + "' by " + member.getName());
    }

    public String getAuthor() { return author; }
}