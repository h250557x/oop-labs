package lab10;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Learner(String name, double gpa) { }

public class GradeReportDemo {
    public static void main(String[] args) {
        // 1. Create a sample learners.csv file
        Path csvPath = Path.of("learners.csv");
        try {
            Files.write(csvPath, List.of(
                    "Tinashe,3.8",
                    "Rudo,2.9",
                    "Farai,3.5",
                    "Nyasha,1.8",
                    "Chipo,3.9",
                    "Tapiwa,2.5"
            ));
        } catch (IOException e) {
            System.out.println("Could not create CSV: " + e.getMessage());
            return;
        }

        try {
            // 2. Read lines and map to Learner objects
            List<Learner> learners = Files.readAllLines(csvPath).stream()
                    .filter(line -> !line.isBlank())
                    .map(line -> {
                        String[] parts = line.split(",");
                        return new Learner(parts[0], Double.parseDouble(parts[1]));
                    })
                    .collect(Collectors.toList());

            // EXPLAIN: Grouping by grade band.
            // GPA >= 3.5 = A, >= 2.5 = B, else = C
            Map<String, List<Learner>> grouped = learners.stream()
                    .collect(Collectors.groupingBy(l -> {
                        if (l.gpa() >= 3.5) return "A";
                        if (l.gpa() >= 2.5) return "B";
                        return "C";
                    }));

            // 3. Write a report file per band
            for (Map.Entry<String, List<Learner>> entry : grouped.entrySet()) {
                String band = entry.getKey();
                List<Learner> bandLearners = entry.getValue();

                // Sort by name inside each band
                bandLearners.sort((l1, l2) -> l1.name().compareTo(l2.name()));

                Path reportPath = Path.of("report_" + band + ".txt");
                List<String> reportLines = bandLearners.stream()
                        .map(l -> l.name() + " - GPA: " + l.gpa())
                        .collect(Collectors.toList());

                Files.write(reportPath, reportLines);
                System.out.println("Wrote report for Grade " + band + " -> " + reportPath);
            }

        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }
}