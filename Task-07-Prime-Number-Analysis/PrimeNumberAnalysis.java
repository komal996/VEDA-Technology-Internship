import java.util.Scanner;

public class PrimeNumberAnalysis {

    // Method to check whether a number is prime
    public static boolean isPrime(int number) {

        if (number < 2) {
            return false;
        }

        // Check divisors up to square root of the number
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Method to generate prime numbers within a range
    public static void generatePrimes(int start, int end) {

        System.out.println("Prime numbers between " + start + " and " + end + ":");

        for (int number = start; number <= end; number++) {

            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prime checker
        System.out.print("Enter a number to check: ");
        int number = scanner.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        // Range-based prime generation
        System.out.print("Enter range start: ");
        int start = scanner.nextInt();

        System.out.print("Enter range end: ");
        int end = scanner.nextInt();

        if (start > end) {
            System.out.println("Invalid range. Start should be less than or equal to end.");
        } else {
            generatePrimes(start, end);
        }

        scanner.close();
    }
}