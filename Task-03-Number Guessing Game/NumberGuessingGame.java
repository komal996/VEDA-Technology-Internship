import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100
        int secretNumber = random.nextInt(100) + 1;

        int guess;
        int attempts = 0;

        System.out.println("=================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("=================================");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Try to guess it!");

        while (true) {

            System.out.print("Enter your guess: ");

            // Check if user entered a valid integer
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            guess = scanner.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("Too low! Try a higher number.");
            } 
            else if (guess > secretNumber) {
                System.out.println("Too high! Try a lower number.");
            } 
            else {
                System.out.println("\nCongratulations!");
                System.out.println("You guessed the correct number: " + secretNumber);
                System.out.println("Number of attempts: " + attempts);
                break;
            }
        }

        scanner.close();
    }
}