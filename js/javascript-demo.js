// JS does not require classes for simple data.
// We can represent a course as an object literal with properties.
// to run, type: node javascript-demo.js (make sure you're in the js directory)

/* 
Java: 
    1. Stricter type checking
    2. Class-based structrue
    3. Private fields and merthods (getter and setter)
    4. Compile-time error
    5. More boilerplate code

JavaScript:
    1. Dyanis typing
    2. Prototype-based structure
    3. No private fields and methods (ES6+ has private fields)
    4. Properties can be accessed and modified at runtime
    5. Less boilerplate code
    6. Obect literals and functions can be used to create objects without classes
    7. Runtime errors
 */

const course = {
    courseId: "C001",
    title: "JavaScript Fundamentals",
    durationHours: 12,
    level: "Beginner",
    instructor: "John Doe",
}

console.log("=== Course Details ===");
console.log(`Course ID: ${course.courseId}`); 
console.log(`Title: ${course.title}`); 
console.log(`Duration: ${course.durationHours} hours`);
console.log(`Level: ${course.level}`);  
console.log(`Instructor: ${course.instructor}`);