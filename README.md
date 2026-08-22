## Day 3 Exercise 01 - Build and Trace the Code Flow

I created a new class called CodeFlowPractice.java. Inside it, I first created the repository, then the service, then I added a new course called C004 (Spring Boot API Development) using the service, and finally I got the course back using the service and printed it.

### Why create the repository first?

The repository is the one that actually holds the data. The service does not store data by itself, so the repository has to exist before we can give it to the service.

### Why does CourseService need CourseRepository?

CourseService does not talk to the LinkedHashMap directly. When we call something like createCourse or getCourseById, the service just passes the request to the repository, and the repository is the one that does the actual saving or finding. That is why the service needs a repository to work with.

### README reflection

Question: When getCourseById("C004") is called, which file does the request go to first, second, and third?

Answer:

1. First it goes to CourseService.java. This is the file we call getCourseById on.
2. Second it goes to CourseRepository.java. This is just the interface, so it does not really "do" anything by itself, it just says findById must exist.
3. Third it goes to InMemoryCourseRepository.java. This is the actual class that implements the interface, and it is the one that looks up "C004" inside the LinkedHashMap and returns the course.

So the flow is CodeFlowPractice -> CourseService -> CourseRepository -> InMemoryCourseRepository -> LinkedHashMap, and then the course comes back the same way in reverse.
