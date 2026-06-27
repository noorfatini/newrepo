const statusMessage = document.getElementById('status-message');
const studentList = document.getElementById('student-list');

function renderStudents(students) {
    studentList.innerHTML = '';

    if (students.length === 0) {
        statusMessage.textContent = 'No students found.';
        return;
    }

    students.forEach((student) => {
        const studentCard = document.createElement("div");

        studentCard.innerHTML = `
            <h2>${student.studentName}</h2>
            <p>Student ID: ${student.studentId}</p>
            <p>Email: ${student.email}</p>
            <p>Status: ${student.status}</p>
        `;

        studentList.appendChild(studentCard);
    });
}

// async function
async function loadStudents() {
    try {
        statusMessage.textContent = "Loading students...";

        const response = await fetch('students.json');   // fetch() request data

        if (!response.ok) {
            throw new Error('Failed to load student data.');
        }

        const students = await response.json();

        statusMessage.textContent = "";
        renderStudents(students);
    } catch (error) {
        statusMessage.textContent = 'Error: ' + error.message;
    }
}

loadStudents();
