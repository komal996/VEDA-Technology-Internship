import java.util.Scanner;

public class PalindromeChecker {

    // Method to check String palindrome
    public static boolean isStringPalindrome(String text) {
        text = text.toLowerCase();

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Method to check Number palindrome
    public static boolean isNumberPalindrome(int number) {
        int original = number;
        int reversed = 0;

        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number = number / 10;
        }

        return original == reversed;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Palindrome Checker =====");
        System.out.println("1. Check String Palindrome");
        System.out.println("2. Check Number Palindrome");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {

            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

            if (isStringPalindrome(text)) {
                System.out.println("\"" + text + "\" is a palindrome.");
            } else {
                System.out.println("\"" + text + "\" is not a palindrome.");
            }

        } else if (choice == 2) {

            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            if (isNumberPalindrome(number)) {
                System.out.println(number + " is a palindrome.");
            } else {
                System.out.println(number + " is not a palindrome.");
            }

        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}