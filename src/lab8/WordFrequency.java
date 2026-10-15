package lab8;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "the quick brown fox jumps over the lazy dog the fox is quick";

        // EXPLAIN: Map -> Key = word, Value = frequency
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Split the paragraph into individual words (lowercase to handle case variations)
        String[] words = paragraph.toLowerCase().split("\\s+");

        for (String word : words) {
            // EXPLAIN: merge() is a clean way to increment or initialize the count
            frequencyMap.merge(word, 1, Integer::sum);
        }

        System.out.println("Word Frequencies: " + frequencyMap);

        // EXPLAIN: To sort by frequency, we convert the Map entries into a List.
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());

        // Sort by value (frequency) in DESCENDING order
        entries.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        System.out.println("\nSorted by frequency (descending):");
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}