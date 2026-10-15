package miniproject;
// EXPLAIN: Abstract class -> partially built class with shared fields and methods
public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;

    protected LibraryItem(String id, String title) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID required");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title required");
        this.id = id;
        this.title = title;
    }

    // EXPLAIN: Abstract method -> every subclass defines its own loan period
    public abstract int loanPeriodDays();

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id=" + id + ", title=" + title + ", available=" + available + "]";
    }
}