
import java.util.Scanner;

public class MultithreadedNumberProcessor {

    // Worker thread for processing a range of numbers
    static class NumberWorker extends Thread {
        private final long start;
        private final long end;
        private long sum = 0;

        public NumberWorker(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (long i = start; i <= end; i++) {
                sum += i;
            }
        }

        public long getSum() {
            return sum;
        }
    }

    // Single-threaded processing
    public static long singleThreaded(long limit) {
        long sum = 0;

        for (long i = 1; i <= limit; i++) {
            sum += i;
        }

        return sum;
    }

    // Multithreaded processing
    public static long multiThreaded(
            long limit, int threadCount)
            throws InterruptedException {

        NumberWorker[] threads =
                new NumberWorker[threadCount];

        long chunkSize = limit / threadCount;

        for (int i = 0; i < threadCount; i++) {
            long start = i * chunkSize + 1;

            long end = (i == threadCount - 1)
                    ? limit
                    : (i + 1) * chunkSize;

            threads[i] = new NumberWorker(start, end);
            threads[i].start();
        }

        long totalSum = 0;

        for (NumberWorker thread : threads) {
            thread.join();
            totalSum += thread.getSum();
        }

        return totalSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(
            "====================================");
        System.out.println(
            "    MULTITHREADED NUMBER PROCESSOR");
        System.out.println(
            "====================================");

        System.out.print(
            "Enter number limit (1 to 100000000): ");
        long limit = sc.nextLong();

        System.out.print("Enter number of threads: ");
        int threadCount = sc.nextInt();

        if (limit <= 0 || limit > 100000000 ||
                threadCount <= 0 ||
                threadCount > limit ||
                threadCount > 32) {

            System.out.println("Invalid input!");
            sc.close();
            return;
        }

        try {
            // Single-threaded execution
            long startTime = System.nanoTime();

            long singleSum = singleThreaded(limit);

            long endTime = System.nanoTime();

            double singleTime =
                (endTime - startTime) / 1000000.0;

            // Multithreaded execution
            startTime = System.nanoTime();

            long multiSum =
                multiThreaded(limit, threadCount);

            endTime = System.nanoTime();

            double multiTime =
                (endTime - startTime) / 1000000.0;

            System.out.println(
                "\n===== SINGLE-THREADED RESULT =====");
            System.out.println("Sum: " + singleSum);
            System.out.printf(
                "Execution Time: %.3f ms%n", singleTime);

            System.out.println(
                "\n===== MULTITHREADED RESULT =====");
            System.out.println("Sum: " + multiSum);
            System.out.println(
                "Threads Used: " + threadCount);
            System.out.printf(
                "Execution Time: %.3f ms%n", multiTime);

            System.out.println(
                "\n===== PERFORMANCE COMPARISON =====");

            if (singleSum == multiSum) {
                System.out.println(
                    "Both results are correct!");
            } else {
                System.out.println(
                    "Results do not match!");
            }

            if (multiTime < singleTime) {
                System.out.println(
                    "Multithreading was faster.");
            } else {
                System.out.println(
                    "Single threading was faster.");
            }

            System.out.println(
                "\nThread Safety: Each thread uses " +
                "its own sum variable.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(
                "Thread execution interrupted.");
        }

        sc.close();
    }
}
