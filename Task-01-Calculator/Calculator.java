import java.util.Scanner;

public class Calculator {

    // Addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Division
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }

    // Modulus
    public static double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot perform modulus by zero.");
        }
        return a % b;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("       COMMAND-LINE CALCULATOR");
        System.out.println("================================");

        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            System.out.println("\nChoose an operation:");
            System.out.println("+  Addition");
            System.out.println("-  Subtraction");
            System.out.println("*  Multiplication");
            System.out.println("/  Division");
            System.out.println("%  Modulus");

            System.out.print("Enter operation: ");
            char operation = scanner.next().charAt(0);

            double result;

            switch (operation) {

                case '+':
                    result = add(num1, num2);
                    break;

                case '-':
                    result = subtract(num1, num2);
                    break;

                case '*':
                    result = multiply(num1, num2);
                    break;

                case '/':
                    result = divide(num1, num2);
                    break;

                case '%':
                    result = modulus(num1, num2);
                    break;

                default:
                    System.out.println("Invalid operation!");
                    return;
            }

            System.out.println("\nResult = " + result);

        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input! Please enter numbers only.");

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}