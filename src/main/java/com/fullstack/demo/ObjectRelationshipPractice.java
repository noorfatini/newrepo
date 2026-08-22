package src.main.java.com.fullstack.demo;

import src.main.java.com.fullstack.demo.model.Course;
import src.main.java.com.fullstack.demo.model.CourseOffering;
import src.main.java.com.fullstack.demo.model.Instructor;

public class ObjectRelationshipPractice {

    public static void main(String[] args) {

        // Task A - create two instructors
        Instructor mike = new Instructor("I001", "Mike Rahman", "Java and Spring Boot");
        Instructor marcus = new Instructor("I002", "Marcus Lee", "React and Frontend Development");

        // Task B - create two courses
        Course javaCourse = new Course("C001", "Java Fundamentals", 14, "Beginner", null, false);
        Course reactCourse = new Course("C002", "React Frontend Development", 21, "Intermediate", null, false);

        // Task C - assign instructors to courses, then print
        javaCourse.setInstructor(mike);
        reactCourse.setInstructor(marcus);

        System.out.println("=== Courses ===");
        javaCourse.printSummary();
        reactCourse.printSummary();

        // Task D and F - CourseOffering uses composition because it has a Course
        // and has an Instructor, instead of just storing their names as text.
        CourseOffering offering1 = new CourseOffering("OFF001", "Java Fundamentals June Intake",
                javaCourse, mike, "2026-06-29", "2026-06-30", 25, "Physical");

        CourseOffering offering2 = new CourseOffering("OFF002", "React Frontend July Intake",
                reactCourse, marcus, "2026-07-01", "2026-07-03", 20, "Hybrid");

        // Extension task - a third offering that reuses the same Java Fundamentals
        // course but with a different date, this shows Course and CourseOffering
        // are not the same thing, one course can have many offerings.
        CourseOffering offering3 = new CourseOffering("OFF003", "Java Fundamentals July Weekend Intake",
                javaCourse, mike, "2026-07-18", "2026-07-19", 15, "Physical");

        System.out.println("\n=== Course Offerings ===");
        offering1.printSummary();
        offering2.printSummary();
        offering3.printSummary();
    }
}
