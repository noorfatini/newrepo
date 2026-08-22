package src.main.java.com.fullstack.demo.service;

import java.util.List;

import src.main.java.com.fullstack.demo.exception.CourseNotFoundException;
import src.main.java.com.fullstack.demo.exception.DuplicateCourseException;
import src.main.java.com.fullstack.demo.exception.InvalidCourseException;
import src.main.java.com.fullstack.demo.model.Course;
import src.main.java.com.fullstack.demo.model.Instructor;
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

    public List<Course> searchByTitle(String keyword) {
        // String safeKeyword;

        // if (keyword == null) {
        //     safeKeyword = "";
        // } else {
        //     safeKeyword = keyword.trim().toLowerCase();
        // }
        String safeKeyword = keyword == null ? "" : keyword.toLowerCase();

        return courseRepository.findAll()
                .stream()
                .filter(course -> course.getTitle().toLowerCase().contains(safeKeyword))
                .toList();
    }

    public List<Course> filterByLevel(String level) {
        String safeLevel = level == null ? "" : level.toLowerCase();

        return courseRepository.findAll()
                .stream()
                .filter(course -> course.getLevel().toLowerCase().equals(safeLevel))
                .toList();
    }

    public Course assignInstructor(String courseId, Instructor instructor) {
        Course course = getCourseById(courseId);
        course.setInstructor(instructor);
        return courseRepository.save(course);
    }

    public List<Course> searchByInstructorName(String instructorName) {
        String safeInstructorName = instructorName == null ? "" : instructorName.toLowerCase();

        return courseRepository.findAll()
                .stream()
                .filter(course -> course.getInstructor() != null)
                .filter(course -> course.getInstructor()
                        .getInstructorName()
                        .toLowerCase()
                        .contains(safeInstructorName))
                        .toList();
    }

    public Course updateDuration(String courseId, int newDurationHours) {
        Course course = getCourseById(courseId);

        if (newDurationHours <= 0) {
            throw new InvalidCourseException("Course duration must be greater than zero.");
        }

        course.setDurationHours(newDurationHours);
        return courseRepository.save(course);
    }

    public void deleteCourse(String courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new CourseNotFoundException(courseId);
        }

        courseRepository.deleteById(courseId);
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
