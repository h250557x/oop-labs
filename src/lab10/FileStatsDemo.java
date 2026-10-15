package lab10;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileStatsDemo {
    public static void main(String[] args) {
        Path filePath = Path.of("stats.txt");

        // First, create a sample file so we have something to read
        try {
            Files.writeString(filePath, "Hello world\nThis is a test file\nJava is fun");
        } catch (IOException e) {
            System.out.println("Could not create file: " + e.getMessage());
            return;
        }

        // Now read the file and calculate stats
        try {
            List<String> lines = Files.readAllLines(filePath);
            int lineCount = lines.size();
            int wordCount = 0;
            int charCount = 0;

            for (String line : lines) {
                // Count characters (excluding newline characters)
                charCount += line.length();

                // EXPLAIN: split("\\s+") splits the line on whitespace (spaces, tabs, etc.)
                if (!line.isBlank()) {
                    wordCount += line.trim().split("\\s+").length;
                }
            }

            System.out.println("File: " + filePath);
            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}