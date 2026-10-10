import java.util.Scanner;

public class MultiplicationTable {

    // Method to generate multiplication table for one number
    public static void generateTable(int number) {
        System.out.println("\nMultiplication Table of " + number);
        System.out.println("----------------------------");

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d%n", number, i, number * i);
        }
    }

    // Method to generate tables for a range of numbers
    public static void generateRangeTables(int start, int end) {
        System.out.println("\nMultiplication Tables from " + start + " to " + end);
        System.out.println("====================================");

        // Nested loops for multiple tables
        for (int number = start; number <= end; number++) {

            System.out.println("\nTable of " + number);
            System.out.println("----------------");

            for (int i = 1; i <= 10; i++) {
                System.out.printf("%d x %d = %d%n",
                        number, i, number * i);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   MULTIPLICATION TABLE GENERATOR");
        System.out.println("=================================");

        System.out.println("\n1. Generate table for one number");
        System.out.println("2. Generate tables for a range");

        System.out.print("\nEnter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {

            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            generateTable(number);

        } else if (choice == 2) {

            System.out.print("Enter starting number: ");
            int start = scanner.nextInt();

            System.out.print("Enter ending number: ");
            int end = scanner.nextInt();

            if (start <= end) {
                generateRangeTables(start, end);
            } else {
                System.out.println("Invalid range! Starting number must be less than or equal to ending number.");
            }

        } else {
            System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}