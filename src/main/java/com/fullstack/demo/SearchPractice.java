package src.main.java.com.fullstack.demo;

import src.main.java.com.fullstack.demo.model.Course;
import src.main.java.com.fullstack.demo.repository.CourseRepository;
import src.main.java.com.fullstack.demo.repository.InMemoryCourseRepository;
import src.main.java.com.fullstack.demo.service.CourseService;

import java.util.List;

public class SearchPractice {

    public static void main(String[] args) {

        CourseRepository courseRepository = new InMemoryCourseRepository();
        CourseService courseService = new CourseService(courseRepository);

        Course javaCourse = new Course("C001", "Java Fundamentals", 14, "Beginner", null, false);
        Course reactCourse = new Course("C002", "React Frontend Development", 21, "Intermediate", null, false);
        Course mongoCourse = new Course("C003", "MongoDB Basics", 10, "Beginner", null, false);
        Course springCourse = new Course("C004", "Spring Boot API Development", 18, "Intermediate", null, false);

        courseService.createCourse(javaCourse);
        courseService.createCourse(reactCourse);
        courseService.createCourse(mongoCourse);
        courseService.createCourse(springCourse);

        System.out.println("=== Beginner Courses (Loop) ===");
        List<Course> beginnerCourses = courseService.searchByLevelUsingLoop("Beginner");
        for (Course course : beginnerCourses) {
            System.out.println(course.getCourseId() + " - " + course.getTitle());
        }

        System.out.println("\n=== Beginner Courses (Stream) ===");
        List<Course> beginnerCoursesStream = courseService.searchByLevelUsingStream("Beginner");
        for (Course course : beginnerCoursesStream) {
            System.out.println(course.getCourseId() + " - " + course.getTitle());
        }
    }
}
