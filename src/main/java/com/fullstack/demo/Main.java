package src.main.java.com.fullstack.demo;

public class Main {
    // Syntax for creating a new object (instance) of the Course class
    // ClassName objectName = new Constructor();
    // ClassName and Constructor usually match
    public static void main(String[] args) {
        Instructor instructor1 = new Instructor("I001", "Dr. Smith", "Computer Science");
        Instructor instructor2 = new Instructor("I002", "Prof. Johnson", "Software Engineering");

        Course course1 = new Course("C001", "Introduction to Computer Science", 40, "Beginner", "Computer Science", true);
        Course course2 = new Course("C002", "Advanced Java Programming", 60, "Intermediate", "Software Engineering", true);

        Student student1 = new Student("S001", "Alice", "alice@example.com");
        Student student2 = new Student("S002", "Bob", "bob@example.com");

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);

        System.out.println("Instructor Profiles:");
        instructor1.printProfile();
        instructor2.printProfile();
        System.out.println();

        System.out.println("Course Summaries:");
        course1.printSummary();
        course2.printSummary();
        System.out.println();

        System.out.println("Student Profiles:");
        student1.printProfile();
        student2.printProfile();
        System.out.println();

    }
}
