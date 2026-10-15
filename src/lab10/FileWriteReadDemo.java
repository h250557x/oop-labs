package lab10;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileWriteReadDemo {
    public static void main(String[] args) {
        Path filePath = Path.of("user_lines.txt");
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter 5 lines of text:");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Line " + i + ": ");
            lines.add(scanner.nextLine());
        }
        scanner.close();

        // EXPLAIN: Files.write() throws a checked IOException. We must handle it.
        try {
            Files.write(filePath, lines);
            System.out.println("\nSuccessfully wrote 5 lines to " + filePath);

            // EXPLAIN: Reading the file back into a List
            List<String> readLines = Files.readAllLines(filePath);
            System.out.println("\n--- Reading back from file ---");
            for (String line : readLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }
}