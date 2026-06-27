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

const courseList = document.getElementById("course-list");
const searchInput = document.getElementById("search-input");
const searchButton = document.getElementById("search-button");
const resetButton = document.getElementById("reset-button");

function renderCourses(courseArray) {
    courseList.innerHTML = "";

    if (courseArray.length === 0) {
        courseList.innerHTML = "<p>No courses found</p>"
    }

    courseArray.forEach((course) => {
        const courseCard = document.createElement("div");

        courseCard.innerHTML = `
            <h2>${course.title}</h2>
            <p>Course ID: ${course.id}</p>
            <p>Duration: ${course.durationHours} hours</p>
            <p>Level: ${course.level}</p>
        `;

        courseList.appendChild(courseCard);
    });
}

/* 
addEventListener    | runs code when the user clicks the search button.
filter              | keeps only mathcing courses based on the keyword
renderCourse        | updates the displayed course list based on the provided array of courses

Java equivalent: searchByTitle(String keyword)
Javasscript equivalent: courses.filter(course.title.toLowerCase().includes(keyword))
*/
searchButton.addEventListener("click", () => {
    const keyword = searchInput.value.trim().toLowerCase();
    
    const results = courses.filter((course) => {
        return course.title.toLowerCase().includes(keyword)
    });

    renderCourses(results);
});

resetButton.addEventListener("click", () => {
    searchInput.value = "";
    renderCourses(courses);
});

renderCourses(courses);
