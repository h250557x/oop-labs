package miniproject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// EXPLAIN: Core service class. Uses Maps for fast lookups by ID.
public class Library {
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final List<Loan> loans = new ArrayList<>();
    private static final int MAX_LOANS_PER_MEMBER = 3;

    public void addItem(LibraryItem item) {
        items.put(item.getId(), item);
    }

    public void registerMember(Member member) {
        members.put(member.getId(), member);
    }

    public void borrow(String memberId, String itemId)
            throws ItemNotAvailableException, MemberLimitExceededException {

        Member member = members.get(memberId);
        if (member == null) throw new IllegalArgumentException("Member not found: " + memberId);

        LibraryItem item = items.get(itemId);
        if (item == null) throw new IllegalArgumentException("Item not found: " + itemId);

        // EXPLAIN: Polymorphism -> calls the borrow() of the actual object type
        item.borrow(member);

        Loan loan = new Loan(member, item, LocalDate.now(), item.loanPeriodDays());
        loans.add(loan);
    }

    public void giveBack(String memberId, String itemId) {
        Member member = members.get(memberId);
        LibraryItem item = items.get(itemId);
        if (member == null || item == null) return;

        item.giveBack(member);

        Loan toRemove = null;
        for (Loan loan : member.getLoans()) {
            if (loan.getItem().getId().equals(itemId)) {
                toRemove = loan;
                break;
            }
        }

        if (toRemove != null) {
            member.removeLoan(toRemove);
            loans.remove(toRemove);
        }
    }

    // EXPLAIN: Streams -> filter and sort results
    public List<LibraryItem> searchByTitle(String text) {
        return items.values().stream()
                .filter(i -> i.getTitle().toLowerCase().contains(text.toLowerCase()))
                .sorted((a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()))
                .collect(Collectors.toList());
    }

    // EXPLAIN: Streams -> find overdue items
    public List<Loan> listOverdueItems() {
        LocalDate today = LocalDate.now();
        return loans.stream()
                .filter(loan -> loan.isOverdue(today))
                .collect(Collectors.toList());
    }

    // =====================================================
    //  FILE PERSISTENCE (Requirement 6)
    // =====================================================
    public void saveToFile(String itemsFile, String membersFile) throws IOException {
        // Save items
        List<String> itemLines = new ArrayList<>();
        for (LibraryItem item : items.values()) {
            if (item instanceof Book book) {
                itemLines.add("BOOK," + book.getId() + "," + book.getTitle()
                        + "," + book.getAuthor() + "," + book.isAvailable());
            } else if (item instanceof Dvd dvd) {
                itemLines.add("DVD," + dvd.getId() + "," + dvd.getTitle()
                        + "," + dvd.getRuntimeMinutes() + "," + dvd.isAvailable());
            }
        }
        Files.write(Path.of(itemsFile), itemLines);

        // Save members
        List<String> memberLines = new ArrayList<>();
        for (Member m : members.values()) {
            memberLines.add(m.getId() + "," + m.getName());
        }
        Files.write(Path.of(membersFile), memberLines);

        System.out.println("Library data saved to " + itemsFile + " and " + membersFile);
    }

    public void loadFromFile(String itemsFile, String membersFile) throws IOException {
        // Load items
        Path itemsPath = Path.of(itemsFile);
        if (Files.exists(itemsPath)) {
            for (String line : Files.readAllLines(itemsPath)) {
                String[] p = line.split(",");
                if (p.length < 5) continue;
                String type = p[0];
                String id = p[1];
                String title = p[2];
                boolean available = Boolean.parseBoolean(p[4]);

                LibraryItem item;
                if (type.equals("BOOK")) {
                    item = new Book(id, title, p[3]);
                } else {
                    item = new Dvd(id, title, Integer.parseInt(p[3]));
                }
                item.setAvailable(available);
                items.put(id, item);
            }
            System.out.println("Loaded " + items.size() + " items from " + itemsFile);
        }

        // Load members
        Path membersPath = Path.of(membersFile);
        if (Files.exists(membersPath)) {
            for (String line : Files.readAllLines(membersPath)) {
                String[] p = line.split(",");
                if (p.length < 2) continue;
                members.put(p[0], new Member(p[0], p[1]));
            }
            System.out.println("Loaded " + members.size() + " members from " + membersFile);
        }
    }
}