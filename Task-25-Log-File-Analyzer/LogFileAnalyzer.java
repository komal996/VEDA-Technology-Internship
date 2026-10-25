
import java.io.*;
import java.util.*;

public class LogFileAnalyzer {

    public static void main(String[] args) {

        String inputFile = "application.log";
        String reportFile = "log_report.txt";

        HashMap<String, Integer> logCounts = new HashMap<>();
        HashMap<String, Integer> errorSummary = new HashMap<>();

        logCounts.put("INFO", 0);
        logCounts.put("WARNING", 0);
        logCounts.put("ERROR", 0);

        int totalLines = 0;
        int invalidLines = 0;

        System.out.println("================================");
        System.out.println("       LOG FILE ANALYZER");
        System.out.println("================================");

        try (BufferedReader reader =
                new BufferedReader(new FileReader(inputFile))) {

            String line;

            while ((line = reader.readLine()) != null) {

                totalLines++;
                line = line.trim();

                // Expected: timestamp LEVEL message
                String[] parts = line.split("\\s+", 3);

                if (parts.length < 3) {
                    invalidLines++;
                    System.out.println(
                        "Invalid log at line " + totalLines);
                    continue;
                }

                String level = parts[1].toUpperCase();
                String message = parts[2];

                if (!logCounts.containsKey(level)) {
                    invalidLines++;
                    System.out.println(
                        "Unknown log level at line " + totalLines);
                    continue;
                }

                logCounts.put(level,
                    logCounts.get(level) + 1);

                if (level.equals("ERROR")) {
                    errorSummary.put(message,
                        errorSummary.getOrDefault(message, 0) + 1);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Log file not found!");
            return;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        StringBuilder report = new StringBuilder();

        report.append("\n========== LOG ANALYSIS REPORT ==========\n");
        report.append("Total Lines     : ").append(totalLines).append("\n");
        report.append("INFO Messages   : ").append(logCounts.get("INFO")).append("\n");
        report.append("WARNING Messages: ").append(logCounts.get("WARNING")).append("\n");
        report.append("ERROR Messages  : ").append(logCounts.get("ERROR")).append("\n");
        report.append("Invalid Lines   : ").append(invalidLines).append("\n");

        report.append("\n========== ERROR SUMMARY ==========\n");

        if (errorSummary.isEmpty()) {
            report.append("No errors found.\n");
        } else {
            for (Map.Entry<String, Integer> entry :
                    errorSummary.entrySet()) {

                report.append(entry.getKey())
                      .append(" : ")
                      .append(entry.getValue())
                      .append(" occurrence(s)\n");
            }
        }

        report.append("=========================================\n");

        System.out.println(report);

        try (PrintWriter writer =
                new PrintWriter(new FileWriter(reportFile))) {

            writer.print(report);
            System.out.println("Report generated: " + reportFile);

        } catch (IOException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }
}
