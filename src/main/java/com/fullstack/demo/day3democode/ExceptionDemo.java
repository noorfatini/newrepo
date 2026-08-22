package src.main.java.com.fullstack.demo.day3democode;

import src.main.java.com.fullstack.demo.exception.CourseNotFoundException;
import src.main.java.com.fullstack.demo.model.Course;
import src.main.java.com.fullstack.demo.repository.CourseRepository;
import src.main.java.com.fullstack.demo.repository.InMemoryCourseRepository;
import src.main.java.com.fullstack.demo.service.CourseService;

public class ExceptionDemo {
    public static void main(String[] args) {
        CourseRepository courseRepository = new InMemoryCourseRepository();
        CourseService courseService = new CourseService(courseRepository);

        Course javaCourse = new Course("C001", "Java Fundamentals", 14, "Beginner", null, false);
        courseService.createCourse(javaCourse);

        try {
            Course foundCourse = courseService.getCourseById("C999");
            foundCourse.printSummary();
        } catch (CourseNotFoundException e) {
            System.out.println("Friendly message for user: " + e.getMessage());
        }
    }
}
