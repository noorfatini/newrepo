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

## Day 3 Exercise 04 - Object Relationships and Composition

I created ObjectRelationshipPractice.java. I made two instructors (Mike Rahman and Marcus Lee) and two courses (Java Fundamentals and React Frontend Development), then assigned each instructor to a course and printed the course summaries. After that I created two CourseOffering objects that link a Course and an Instructor together with dates, capacity, and delivery mode, and printed both. For the extension task, I added a third offering (OFF003) that reuses the same Java Fundamentals course but with a different date, just to show one course can have more than one offering.

### README reflection

Question: Why is CourseOffering a better design than putting start date, end date, and capacity directly inside Course?

Answer:

If we put start date, end date, and capacity directly inside Course, that means one course can only have one schedule at a time. But in real life, the same course like Java Fundamentals can run many times, for example once in June and once in July, with different dates, different capacity, and maybe even a different instructor.

By keeping those details in a separate CourseOffering class instead, Course just stays as the general info (title, level, duration), and CourseOffering becomes the specific "run" of that course. So we can create OFF001 and OFF003 that both point to the same Java Fundamentals course but have completely different dates and capacity, without duplicating or overwriting the course data. This is the composition part, CourseOffering has a Course and has an Instructor, instead of copying their info as plain text fields.

## Day 3 Exercise 05 - Write Search Using Loop, Then Compare with Stream

I added searchByLevelUsingLoop() to CourseService.java. It treats null as an empty string, trims the level, uses equalsIgnoreCase() to compare, and loops through courseRepository.findAll() to collect matching courses into a new ArrayList. I also did the optional Task D and added searchByLevelUsingStream(), which does the same thing but using stream() and filter() instead of a for loop.

Then I created SearchPractice.java, added four courses (C001, C002, C003, C004), and called both methods with "Beginner" as the level. Both versions return the same result, C001 and C003, which are the two Beginner courses.

### README reflection

Question: Which version is easier to understand: loop or stream? Why?

Answer:

For me the loop version is easier to understand at first, because I can see every step clearly, create the empty list, go through each course one by one, check the condition, then add it if it matches. It reads almost like normal instructions.

The stream version is shorter and looks cleaner once I already understand what filter() is doing, but if I did not write the loop version first, I think the stream version would be confusing because it hides the loop and the ArrayList inside it.

Question: What does filter() do in a stream?

Answer:

filter() goes through each item in the stream and only keeps the ones that match the condition inside it, basically it does the same job as the if statement inside my loop version, just written in a shorter way.

## Day 3 Exercise 06 - Build StudentService Using the Same Pattern as CourseService

For this one I rebuilt the same repository and service pattern, but for Student instead of Course. I created StudentRepository (interface only, no storage code), InMemoryStudentRepository (uses a LinkedHashMap, same as the course one), StudentNotFoundException, and StudentService with registerStudent, getStudentById, getAllStudents, and searchByNameUsingLoop.

I also did the extension task, I added DuplicateStudentException and made registerStudent throw that instead of IllegalArgumentException when the student ID already exists, and I added searchByNameUsingStream as the stream version of the search method.

Then I created Day3_Assignment06_StudentServicePractice.java to test everything. I registered 3 students (S001, S002, S003), printed all of them, found one by ID, searched by name using both the loop and the stream version, and tried to find a missing student (S999) which correctly throws StudentNotFoundException and gets caught without crashing the program.

### README reflection

Question: How is StudentService similar to CourseService?

Answer:

StudentService follows the exact same structure as CourseService. Both of them only hold a reference to their repository interface (StudentRepository / CourseRepository) through the constructor, they do not store any data themselves. Both have a method to register/create, a method to get one by ID that throws a not-found exception if it does not exist, a method to get all, and a search method that has both a loop version and a stream version. Basically once you understand one of them, you already understand the pattern for the other one, just the field names are different.

Question: Which file stores students temporarily while the program is running?

Answer:

InMemoryStudentRepository.java is the one that stores students temporarily, because it holds the actual LinkedHashMap in memory. Once the program stops running, that data is gone, same idea as InMemoryCourseRepository for courses.
