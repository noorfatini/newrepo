package src.main.java.com.fullstack.demo;

import src.main.java.com.fullstack.demo.model.Course;
import src.main.java.com.fullstack.demo.repository.CourseRepository;
import src.main.java.com.fullstack.demo.repository.InMemoryCourseRepository;
import src.main.java.com.fullstack.demo.service.CourseService;

public class CodeFlowPractice {

    public static void main(String[] args) {

        // We create the repository first because the service needs a repository
        // to work. The repository is the one that actually stores the data.
        CourseRepository courseRepository = new InMemoryCourseRepository();

        // CourseService needs CourseRepository because the service does not
        // store data by itself. It passes the request to the repository
        // to save or find the course.
        CourseService courseService = new CourseService(courseRepository);

        System.out.println("=== Add and Find Course ===");

        // Task B - create a new course and save it through the service,
        // not directly through the repository.
        Course springCourse = new Course("C004", "Spring Boot API Development", 18, "Intermediate", null, false);
        courseService.createCourse(springCourse);

        // Task C - retrieve the same course by ID through the service.
        Course foundCourse = courseService.getCourseById("C004");
        foundCourse.printSummary();

        // Trace of the flow for getCourseById("C004"):
        // 1. CodeFlowPractice (this class) calls courseService.getCourseById("C004").
        // 2. CourseService receives the request and calls courseRepository.findById("C004").
        // 3. CourseRepository is the interface, so the call actually goes to InMemoryCourseRepository.
        // 4. InMemoryCourseRepository looks up "C004" in its LinkedHashMap and returns the Course.
        // 5. CourseService gets the Course back and returns it to CodeFlowPractice.
    }
}
