package src.main.java.com.fullstack.demo;

import src.main.java.com.fullstack.demo.exception.CourseNotFoundException;
import src.main.java.com.fullstack.demo.model.Course;
import src.main.java.com.fullstack.demo.repository.CourseRepository;
import src.main.java.com.fullstack.demo.repository.InMemoryCourseRepository;
import src.main.java.com.fullstack.demo.service.CourseService;

public class ExceptionPractice {

    public static void main(String[] args) {

        CourseRepository courseRepository = new InMemoryCourseRepository();
        CourseService courseService = new CourseService(courseRepository);

        Course javaCourse = new Course("C001", "Java Fundamentals", 14, "Beginner", null, false);
        Course reactCourse = new Course("C002", "React Frontend Development", 21, "Intermediate", null, false);

        courseService.createCourse(javaCourse);
        courseService.createCourse(reactCourse);

        // Task C - find an existing course, this should work normally
        Course course = courseService.getCourseById("C001");
        course.printSummary();

        // Task D - find a missing course and catch the exception instead of crashing
        try {
            Course missingCourse = courseService.getCourseById("C999");
            missingCourse.printSummary();
        } catch (CourseNotFoundException e) {
            System.out.println("Friendly message for user: " + e.getMessage());
        }

        // Task E - another missing course, with a different friendly message
        try {
            courseService.getCourseById("C888");
        } catch (CourseNotFoundException e) {
            System.out.println("Cannot display course details because the course does not exist.");
        }
    }
}
