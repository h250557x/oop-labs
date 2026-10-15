package lab8;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueNamesDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Tinashe");
        names.add("Rudo");
        names.add("Tinashe"); // Duplicate
        names.add("Farai");
        names.add("Rudo");   // Duplicate
        names.add("Nyasha");

        System.out.println("Original list with duplicates: " + names);

        // EXPLAIN: A Set does not allow duplicates.
        // Passing the List into the Set constructor automatically removes duplicates.
        Set<String> uniqueNames = new HashSet<>(names);

        // EXPLAIN: Converting back to a List (optional, but often useful)
        List<String> cleanedList = new ArrayList<>(uniqueNames);

        System.out.println("List after removing duplicates: " + cleanedList);
    }
}