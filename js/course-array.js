/* 
    Java
    List<Courses> courses = new ArrayList<>();

    JS
    const courses = [];
*/

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
        level: "Intermediate"
    }
];

console.log("=== Course Details ===");

// `` called backticks, used for template literals
// enchanced for loop in Java similar to for..of loop in JS

for (const c of courses) {
    console.log(`${c.id}: ${c.title} - Duration: ${c.durationHours} hours - Level: (${c.level})`);
}

console.log("\nTotal Courses: " + courses.length);  // .size() in Java is .length in JS