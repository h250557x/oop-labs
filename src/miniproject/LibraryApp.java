package miniproject;

import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    private static final Library library = new Library();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ITEMS_FILE = "items.csv";
    private static final String MEMBERS_FILE = "members.csv";

    public static void main(String[] args) {
        // Load saved data on startup
        try {
            library.loadFromFile(ITEMS_FILE, MEMBERS_FILE);
        } catch (Exception e) {
            System.out.println("No saved data found. Starting fresh.");
        }

        seedData();

        // Save on exit
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                library.saveToFile(ITEMS_FILE, MEMBERS_FILE);
            } catch (Exception e) {
                System.out.println("Could not save data: " + e.getMessage());
            }
        }));

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Item");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Item");
            System.out.println("4. Return Item");
            System.out.println("5. Search by Title");
            System.out.println("6. List Overdue Items");
            System.out.println("7. Save Data");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> addItem();
                    case "2" -> registerMember();
                    case "3" -> borrowItem();
                    case "4" -> returnItem();
                    case "5" -> searchByTitle();
                    case "6" -> listOverdue();
                    case "7" -> library.saveToFile(ITEMS_FILE, MEMBERS_FILE);
                    case "0" -> { System.out.println("Goodbye!"); System.exit(0); }
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addItem() {
        System.out.print("Type (BOOK/DVD): ");
        String type = scanner.nextLine().toUpperCase();
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();

        if (type.equals("BOOK")) {
            System.out.print("Author: ");
            String author = scanner.nextLine();
            library.addItem(new Book(id, title, author));
        } else if (type.equals("DVD")) {
            System.out.print("Runtime (mins): ");
            int runtime = Integer.parseInt(scanner.nextLine());
            library.addItem(new Dvd(id, title, runtime));
        } else {
            System.out.println("Invalid type.");
            return;
        }
        System.out.println("Item added.");
    }

    private static void registerMember() {
        System.out.print("Member ID: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        library.registerMember(new Member(id, name));
        System.out.println("Member registered.");
    }

    private static void borrowItem() {
        System.out.print("Member ID: ");
        String mId = scanner.nextLine();
        System.out.print("Item ID: ");
        String iId = scanner.nextLine();
        try {
            library.borrow(mId, iId);
        } catch (ItemNotAvailableException e) {
            System.out.println("Cannot borrow: " + e.getMessage());
        } catch (MemberLimitExceededException e) {
            System.out.println("Cannot borrow: " + e.getMessage());
        }
    }

    private static void returnItem() {
        System.out.print("Member ID: ");
        String mId = scanner.nextLine();
        System.out.print("Item ID: ");
        String iId = scanner.nextLine();
        library.giveBack(mId, iId);
    }

    private static void searchByTitle() {
        System.out.print("Search text: ");
        String text = scanner.nextLine();
        List<LibraryItem> results = library.searchByTitle(text);
        if (results.isEmpty()) {
            System.out.println("No items found.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private static void listOverdue() {
        List<Loan> overdue = library.listOverdueItems();
        if (overdue.isEmpty()) {
            System.out.println("No overdue items.");
        } else {
            overdue.forEach(System.out::println);
        }
    }

    private static void seedData() {
        library.addItem(new Book("B1", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addItem(new Book("B2", "1984", "George Orwell"));
        library.addItem(new Dvd("D1", "Inception", 148));
        library.registerMember(new Member("M1", "Tinashe"));
        library.registerMember(new Member("M2", "Rudo"));
    }
}