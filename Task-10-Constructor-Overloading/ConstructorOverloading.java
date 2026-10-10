
class Student {
    String name;
    int age;
    String course;

    // Default constructor
    Student() {
        name = "Unknown";
        age = 0;
        course = "Not Assigned";
    }

    // Constructor with two parameters
    Student(String name, int age) {
        this.name = name;
        this.age = age;
        course = "Java";
    }

    // Constructor with three parameters
    Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Display student details
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("--------------------");
    }
}

public class ConstructorOverloading {
    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student("Komal", 23);
        Student s3 = new Student("Rahul", 22, "Python");

        System.out.println("Student 1:");
        s1.display();

        System.out.println("Student 2:");
        s2.display();

        System.out.println("Student 3:");
        s3.display();
    }
}
