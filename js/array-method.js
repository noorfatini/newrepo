const courses = [
    {
        id: "C001",
        title: "JavaScript Fundamentals",
        durationHours: 12,
        level: "Beginner"
    },
    {
        id: "C002",
        title: "Advanced JavaScript",
        durationHours: 20,
        level: "Advanced"
    },
    {
        id: "C003",
        title: "Web Development with JavaScript",
        durationHours: 24,
        level: "Beginner"
    },
    {
        id: "C004",
        title: "JavaScript Libraries and Frameworks",
        durationHours: 16,
        level: "Intermediate"
    }
];

/*
=========== JavaScript Array Methods for React ===========
    forEach | Do something for every item       | Returns undefined
    filter  | Keep items that match condition   | Returns a new array
    find    | Find the first matching item      | Returns one item or undefined
    map     | Transform each item               | Returns a new array

=========== Other JavaScript Array Methods ===========
    push    | Add to the END of array           | Returns new length
    pop     | Remove from the END of array      | Returns removed item
    unshift | Add to the START of array         | Returns new length
    shift   | Remove from the START of array    | Returns removed item
*/


// ── forEach ──────────────────────────────────────────────
console.log("=== forEach: Print all course titles ===");

courses.forEach((course) => {
    console.log(course.title);
});


// ── filter ───────────────────────────────────────────────
/* 
Java equivalent: 

courses.stream()
    .filter(c -> c.getLevel().equals("Beginner")).collect(Collectors
    .toList()) 
*/
console.log("\n=== filter: Get all beginner courses ===");

const beginnerCourses = courses.filter((course) => course.level === "Beginner");
console.log(beginnerCourses);


// ── find ─────────────────────────────────────────────────
console.log("\n=== find: Course C002 ===");

const foundCourse = courses.find((course) => {
    return course.id === "C002";
});
console.log(foundCourse);


// ── map ──────────────────────────────────────────────────
console.log("\n=== map: Course titles only ===");

const courseTitles = courses.map((course) => course.title);
console.log(courseTitles);


// ── push ─────────────────────────────────────────────────
console.log("\n=== push: New length after adding a course ===");

const newLengthAfterPush = courses.push({
    id: "C005",
    title: "React Fundamentals",
    durationHours: 18,
    level: "Beginner"
});
console.log(courses);
console.log("New length after push: " + newLengthAfterPush);


// ── pop ──────────────────────────────────────────────────
console.log("\n=== pop: Removed last course ===");

const removedCourse = courses.pop();
console.log("Removed course: " + removedCourse.title);
console.log(courses);
console.log("New length after pop: " + courses.length);


// ── unshift ──────────────────────────────────────────────
console.log("\n=== unshift: New length after adding a course at the beginning ===");

const newLengthAfterUnshift = courses.unshift({
    id: "C000",
    title: "Introduction to Programming",
    durationHours: 10,
    level: "Beginner"
});
console.log(courses);
console.log("New length after unshift: " + newLengthAfterUnshift);


// ── shift ────────────────────────────────────────────────
console.log("\n=== shift: Removed first course ===");

const removedFirstCourse = courses.shift();
console.log("Removed course: " + removedFirstCourse.title);
console.log(courses);
console.log("New length after shift: " + courses.length);
