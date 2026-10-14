import java.util.Scanner;

// Abstract class
abstract class Shape {
    abstract double calculateArea();
    abstract double calculatePerimeter();

    void displayResult() {
        System.out.printf("Area: %.2f%n", calculateArea());
        System.out.printf("Perimeter: %.2f%n",
                          calculatePerimeter());
    }
}

// Circle class
class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle class
class Rectangle extends Shape {
    private double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Triangle class
class Triangle extends Shape {
    private double a, b, c;

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double calculateArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) *
                         (s - b) * (s - c));
    }

    @Override
    double calculatePerimeter() {
        return a + b + c;
    }
}

// Main class
public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                "\n===== SHAPE CALCULATOR =====");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice!");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();

            if (choice == 4) {
                System.out.println(
                    "Thank you for using Shape Calculator!");
                break;
            }

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice!");
                continue;
            }

            Shape shape = null;

            switch (choice) {
                case 1:
                    System.out.print("Enter radius: ");
                    double radius = sc.nextDouble();

                    if (radius <= 0) {
                        System.out.println(
                            "Radius must be positive!");
                        break;
                    }

                    shape = new Circle(radius);
                    break;

                case 2:
                    System.out.print("Enter length: ");
                    double length = sc.nextDouble();

                    System.out.print("Enter width: ");
                    double width = sc.nextDouble();

                    if (length <= 0 || width <= 0) {
                        System.out.println(
                            "Dimensions must be positive!");
                        break;
                    }

                    shape = new Rectangle(length, width);
                    break;

                case 3:
                    System.out.print("Enter side 1: ");
                    double a = sc.nextDouble();

                    System.out.print("Enter side 2: ");
                    double b = sc.nextDouble();

                    System.out.print("Enter side 3: ");
                    double c = sc.nextDouble();

                    if (a <= 0 || b <= 0 || c <= 0 ||
                        a + b <= c ||
                        a + c <= b ||
                        b + c <= a) {
                        System.out.println(
                            "Invalid triangle sides!");
                        break;
                    }

                    shape = new Triangle(a, b, c);
                    break;
            }

            if (shape != null) {
                System.out.println(
                    "\n----- CALCULATION RESULT -----");
                shape.displayResult();
            }
        }

        sc.close();
    }
}
