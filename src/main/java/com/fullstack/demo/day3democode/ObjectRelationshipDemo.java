package src.main.java.com.fullstack.demo.day3democode;

import src.main.java.com.fullstack.demo.model.Course;
import src.main.java.com.fullstack.demo.model.CourseOffering;
import src.main.java.com.fullstack.demo.model.Instructor;

public class ObjectRelationshipDemo {
    public static void main(String[] args) {
        // Composition: Course has an Instructor, CourseOffering has a Course and an Instructor
        // Composition means that the lifetime of the composed objects (Instructor, Course) is managed by the containing object (Course, CourseOffering). 
        // If the containing object is destroyed, the composed objects are also destroyed.
        
        Instructor instructor = new Instructor("I001", "Aina Rahman", "Java and Spring Boot");
        Course course = new Course("C001", "Java Fundamentals", 14, "Beginner", null, false);

        course.setInstructor(instructor);

        CourseOffering offering = new CourseOffering(
                "OFF001",
                "Java Fundamentals - June Intake",
                course,
                instructor,
                "2026-06-25",
                "2026-06-26",
                25,
                "Physical"
        );

        System.out.println("=== Course has an Instructor ===");
        course.printSummary();

        System.out.println("=== CourseOffering has a Course and Instructor ===");
        offering.printSummary();
    }
}
