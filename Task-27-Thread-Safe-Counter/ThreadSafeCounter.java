import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {

    static final int THREADS = 10;
    static final int INCREMENTS = 100000;

    // 1. Unsafe Counter
    static class UnsafeCounter {
        private int count = 0;

        public void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    // 2. Synchronized Counter
    static class SynchronizedCounter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public synchronized int getCount() {
            return count;
        }
    }

    // 3. AtomicInteger Counter
    static class AtomicCounter {
        private AtomicInteger count =
                new AtomicInteger(0);

        public void increment() {
            count.incrementAndGet();
        }

        public int getCount() {
            return count.get();
        }
    }

    // Run multiple threads
    public static long runThreads(Runnable task)
            throws InterruptedException {

        Thread[] threads = new Thread[THREADS];

        long start = System.nanoTime();

        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    task.run();
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return System.nanoTime() - start;
    }

    public static void main(String[] args)
            throws InterruptedException {

        System.out.println(
            "====================================");
        System.out.println(
            "       THREAD SAFE COUNTER");
        System.out.println(
            "====================================");

        int expected = THREADS * INCREMENTS;

        System.out.println("Threads: " + THREADS);
        System.out.println(
            "Increments per Thread: " + INCREMENTS);
        System.out.println(
            "Expected Count: " + expected);

        // Unsafe Counter
        UnsafeCounter unsafe = new UnsafeCounter();

        long unsafeTime =
                runThreads(unsafe::increment);

        System.out.println(
            "\n----- UNSAFE COUNTER -----");
        System.out.println(
            "Final Count: " + unsafe.getCount());
        System.out.println(
            "Lost Updates: " +
            (expected - unsafe.getCount()));
        System.out.printf(
            "Time: %.3f ms%n",
            unsafeTime / 1_000_000.0);

        // Synchronized Counter
        SynchronizedCounter safe =
                new SynchronizedCounter();

        long safeTime =
                runThreads(safe::increment);

        System.out.println(
            "\n----- SYNCHRONIZED COUNTER -----");
        System.out.println(
            "Final Count: " + safe.getCount());
        System.out.println(
            "Lost Updates: " +
            (expected - safe.getCount()));
        System.out.printf(
            "Time: %.3f ms%n",
            safeTime / 1_000_000.0);

        // AtomicInteger Counter
        AtomicCounter atomic = new AtomicCounter();

        long atomicTime =
                runThreads(atomic::increment);

        System.out.println(
            "\n----- ATOMIC INTEGER COUNTER -----");
        System.out.println(
            "Final Count: " + atomic.getCount());
        System.out.println(
            "Lost Updates: " +
            (expected - atomic.getCount()));
        System.out.printf(
            "Time: %.3f ms%n",
            atomicTime / 1_000_000.0);

        // Performance Comparison
        System.out.println(
            "\n----- PERFORMANCE COMPARISON -----");

        System.out.printf(
            "Unsafe Counter      : %.3f ms%n",
            unsafeTime / 1_000_000.0);

        System.out.printf(
            "Synchronized Counter: %.3f ms%n",
            safeTime / 1_000_000.0);

        System.out.printf(
            "Atomic Counter      : %.3f ms%n",
            atomicTime / 1_000_000.0);

        System.out.println(
            "\n----- CONCLUSION -----");
        System.out.println(
            "Unsafe counter may lose updates.");
        System.out.println(
            "Synchronized counter is thread-safe.");
        System.out.println(
            "AtomicInteger counter is thread-safe.");

        System.out.println(
            "\nTask Completed Successfully!");
    }
}
