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

## Day 3 Exercise 02 - Interface and Repository Storage Practice

I created RepositoryPractice.java. This time I did not use CourseService at all, I called the repository directly. I saved three courses (C005, C006, C007) using courseRepository.save(), printed all of them with a loop, found C006 using Optional, and checked if C007 exists using existsById().

### README reflection

Question: Why is InMemoryCourseRepository temporary storage? What would probably replace it later when we use MongoDB?

Answer:

InMemoryCourseRepository is temporary because it only keeps the data inside a LinkedHashMap, which lives in the program's memory while it is running. Once we stop the program, everything inside that map is gone, nothing is actually saved anywhere permanent.

Later when we use MongoDB, there will probably be a new class like MongoCourseRepository that also implements the CourseRepository interface, but instead of using a LinkedHashMap, it will actually connect to a MongoDB database and save the data there so it does not disappear when the program stops. Since CourseService only depends on the CourseRepository interface and not on InMemoryCourseRepository directly, we can swap it to MongoCourseRepository later without changing the service code.

## Day 3 Exercise 03 - Exception Practice with CourseService

I created ExceptionPractice.java. I created two courses (C001 and C002) through the service, then printed C001 normally to show it works. After that I searched for C999 and C888, which do not exist, and wrapped both in try/catch so the program does not crash. Each catch block prints a different friendly message instead of letting the program stop.

### README reflection

Question: Why is throwing CourseNotFoundException better than printing inside CourseService?

Answer:

If CourseService just prints "Course not found" directly, that message is stuck as a console print, it cannot be reused anywhere else. But if the service throws CourseNotFoundException instead, the service is just saying "something went wrong here", and it lets whoever is calling it decide how to show that error.

This matters because the same CourseService might be used by different types of callers. A console app can catch it and print a message like I did in ExceptionPractice. A web API can catch the same exception and turn it into a proper error response, like a 404 status with a JSON message. A frontend app can catch it and show a popup or a red text under the search box. If the service already printed the message itself, none of these other callers would be able to control how the error looks, they would just get a random println in the terminal that is not even useful for them.
