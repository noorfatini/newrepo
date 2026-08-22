package src.main.java.com.fullstack.demo.day3democode;

import src.main.java.com.fullstack.demo.model.Course;
import src.main.java.com.fullstack.demo.repository.CourseRepository;
import src.main.java.com.fullstack.demo.repository.InMemoryCourseRepository;
import src.main.java.com.fullstack.demo.service.CourseService;

public class CodeFlowDemo {
    public static void main(String[] args) {
        CourseRepository courseRepository = new InMemoryCourseRepository();
        CourseService courseService = new CourseService(courseRepository);

        Course javaCourse = new Course("C001", "Java Fundamentals", 14, "Beginner", null, false);
        courseService.createCourse(javaCourse);

        Course foundCourse = courseService.getCourseById("C001");
        foundCourse.printSummary();
    }
}
