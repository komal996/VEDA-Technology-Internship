
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class MultithreadedFileSearch {

    static class SearchTask implements Callable<List<String>> {
        private final Path file;
        private final String keyword;

        SearchTask(Path file, String keyword) {
            this.file = file;
            this.keyword = keyword.toLowerCase();
        }

        @Override
        public List<String> call() {
            List<String> results = new ArrayList<>();

            try (BufferedReader reader =
                    Files.newBufferedReader(file)) {

                String line;
                int lineNumber = 0;

                while ((line = reader.readLine()) != null) {
                    lineNumber++;

                    if (line.toLowerCase().contains(keyword)) {
                        results.add(
                            "File: " + file.getFileName()
                            + " | Line: " + lineNumber
                            + " | Text: " + line.trim()
                        );
                    }
                }

            } catch (IOException e) {
                results.add("Error reading " + file
                        + ": " + e.getMessage());
            }

            return results;
        }
    }

    static List<String> sequentialSearch(
            List<Path> files, String keyword) {

        List<String> results = new ArrayList<>();

        for (Path file : files) {
            results.addAll(
                new SearchTask(file, keyword).call()
            );
        }

        return results;
    }

    static List<String> parallelSearch(
            List<Path> files, String keyword)
            throws InterruptedException, ExecutionException {

        int threadCount = Math.min(
            4, Math.max(1, files.size())
        );

        ExecutorService executor =
                Executors.newFixedThreadPool(threadCount);

        try {
            List<Future<List<String>>> futures =
                    new ArrayList<>();

            for (Path file : files) {
                futures.add(executor.submit(
                    new SearchTask(file, keyword)
                ));
            }

            List<String> results = new ArrayList<>();

            for (Future<List<String>> future : futures) {
                results.addAll(future.get());
            }

            return results;

        } finally {
            executor.shutdown();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("   MULTITHREADED FILE SEARCH TOOL");
        System.out.println("====================================");

        System.out.print("Enter keyword to search: ");
        String keyword = scanner.nextLine().trim();

        if (keyword.isEmpty()) {
            System.out.println("Keyword cannot be empty!");
            return;
        }

        List<Path> files = new ArrayList<>();

        try (DirectoryStream<Path> stream =
                Files.newDirectoryStream(Paths.get("files"), "*.txt")) {

            for (Path file : stream) {
                if (Files.isRegularFile(file)) {
                    files.add(file);
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        if (files.isEmpty()) {
            System.out.println("No text files found!");
            return;
        }

        files.sort(Comparator.naturalOrder());

        System.out.println("\nTotal files: " + files.size());

        long startSequential = System.nanoTime();

        List<String> sequential =
                sequentialSearch(files, keyword);

        long endSequential = System.nanoTime();

        long startParallel = System.nanoTime();

        try {
            List<String> parallel =
                    parallelSearch(files, keyword);

            long endParallel = System.nanoTime();

            System.out.println("\n--- SEARCH RESULTS ---");

            if (parallel.isEmpty()) {
                System.out.println("No matches found.");
            } else {
                for (String result : parallel) {
                    System.out.println(result);
                }
            }

            System.out.println("\n--- PERFORMANCE ---");

            double sequentialTime =
                    (endSequential - startSequential) / 1_000_000.0;

            double parallelTime =
                    (endParallel - startParallel) / 1_000_000.0;

            System.out.printf(
                "Sequential Time: %.3f ms%n", sequentialTime
            );

            System.out.printf(
                "Multithreaded Time: %.3f ms%n", parallelTime
            );

            System.out.println(
                "Total Matches: " + parallel.size()
            );

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Search interrupted.");

        } catch (ExecutionException e) {
            System.out.println("Search failed: " + e.getCause());
        }
    }
}
