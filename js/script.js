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
    }
];

/* 
DOM Rendering and Manipulation

HTML    = Page Structure
CSS     = Page Styling
JS      = Page Behaviour
DOM     = Document Object Model browser's object version of the HTML page
*/
const courseList = document.getElementById("course-list"); // Fiding the elemetn with id="course=list" in the HTML page

courses.forEach((course) => {
    const courseCard = document.createElement("div"); // Creating new div element

    courseCard.innerHTML = `
        <h2>${course.title}</h2>
        <p>Course ID: ${course.id}</p>
        <p>Duration: ${course.durationHours} hours</p>
        <p>Level: ${course.level}</p>
    `;

    courseList.appendChild(courseCard); // Put the new element into the page under the element with id="course=lsit"
});