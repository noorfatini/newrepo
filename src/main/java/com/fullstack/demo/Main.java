package src.main.java.com.fullstack.demo;

import java.util.ArrayList;
import java.util.List;

import src.main.java.com.fullstack.demo.model.Course;
import src.main.java.com.fullstack.demo.model.CourseOffering;
import src.main.java.com.fullstack.demo.model.Instructor;
import src.main.java.com.fullstack.demo.repository.InMemoryCourseRepository;
import src.main.java.com.fullstack.demo.model.Student;

public class Main {
    // Syntax for creating a new object (instance) of the Course class
    // ClassName objectName = new Constructor();
    // ClassName and Constructor usually match
    public static void main(String[] args) {
        Instructor instructor1 = new Instructor("I001", "Dr. Smith", "Computer Science");
        Instructor instructor2 = new Instructor("I002", "Prof. Johnson", "Software Engineering");

        Course course1 = new Course("C001", "Introduction to Computer Science", 40, "Beginner", "Computer Science", true);
        Course course2 = new Course("C002", "Advanced Java Programming", 60, "Intermediate", "Software Engineering", true);
        Course course3 = new Course("C003", "Data Structures and Algorithms", 50, "Intermediate", "Computer Science", true);

        Student student1 = new Student("S001", "Alice", "alice@example.com");
        Student student2 = new Student("S002", "Bob", "bob@example.com");
        Student student3 = new Student("S003", "Charlie", "charlie@example.com");

        CourseOffering offering1 = new CourseOffering("OFF001", "Intro to CS - June 2026 Intake", course1, instructor1, "2026-06-19", "2026-06-20", 25, "Physical");
        CourseOffering offering2 = new CourseOffering("OFF002", "Advanced Java - June 2026 Intake", course2, instructor2, "2026-06-19", "2026-06-20", 30, "Hybrid");
        

        // Store object in ArrayList
        List<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);

        // enhanced for loop
        for (Course course : courseList) {
            course.printSummary();
            System.out.println(courseList.size());
        }
        for (int i = 0; i < courseList.size(); i++) {
            Course course = courseList.get(i);
            course.printSummary();
        }

        // Day 2 Assignment 02 - store instructors, students, offerings in ArrayList too
        ArrayList<Instructor> instructors = new ArrayList<>();
        instructors.add(instructor1);
        instructors.add(instructor2);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        ArrayList<CourseOffering> offerings = new ArrayList<>();
        offerings.add(offering1);
        offerings.add(offering2);

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);
        course3.setInstructor(instructor1);

        System.out.println("Instructor Profiles:");
        instructor1.getProfile();
        instructor2.getProfile();
        System.out.println();

        System.out.println("Course Summaries:");
        course1.printSummary();
        course2.printSummary();
        course3.printSummary();
        System.out.println();

        System.out.println("Student Profiles:");
        student1.printProfile();
        student2.printProfile();
        System.out.println();

        System.out.println("Course Offerings:");
        offering1.printSummary();
        offering2.printSummary();
        System.out.println();

        // Day 2 Assignment 02 - print all lists using enhanced for loop
        System.out.println("All Instructors (from ArrayList):");
        for (Instructor i : instructors) {
            i.getProfile();
        }
        System.out.println();

        System.out.println("All Students (from ArrayList):");
        for (Student s : students) {
            s.printProfile();
        }
        System.out.println();

        System.out.println("All Course Offerings (from ArrayList):");
        for (CourseOffering o : offerings) {
            o.printSummary();
        }
        System.out.println();
    }
}
