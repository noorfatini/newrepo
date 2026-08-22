package src.main.java.com.fullstack.demo.service;

import java.util.List;

import src.main.java.com.fullstack.demo.exception.CourseNotFoundException;
import src.main.java.com.fullstack.demo.exception.DuplicateCourseException;
import src.main.java.com.fullstack.demo.exception.InvalidCourseException;
import src.main.java.com.fullstack.demo.model.Course;
import src.main.java.com.fullstack.demo.repository.CourseRepository;

public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        validateCourse(course);

        if (courseRepository.existsById(course.getCourseId())) {
            throw new DuplicateCourseException(course.getCourseId());
        }

        return courseRepository.save(course);
    }

    public Course getCourseById(String courseId) {
        // public Course getCourseById(String courseId) {
        //     Optional<Course> optionalCourse = courseRepository.findById(courseId);
        //     if (optionalCourse.isPresent()) {
        //         return optionalCourse.get();
        //     } else {
        //         throw new CourseNotFoundException(courseId);
        //     }
        // }
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(courseId));
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    private void validateCourse(Course course) {
        if (course == null) {
            throw new InvalidCourseException("Course cannot be null.");
        }
        if (isBlank(course.getCourseId())) {
            throw new InvalidCourseException("Course ID is required.");
        }
        if (isBlank(course.getTitle())) {
            throw new InvalidCourseException("Course title is required.");
        }
        if (course.getDurationHours() <= 0) {
            throw new InvalidCourseException("Course duration must be greater than zero.");
        }
        if (isBlank(course.getLevel())) {
            throw new InvalidCourseException("Course level is required.");
        }
    }

    // simple check if a string is empty or just spaces
    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
