const student = {
    studentId: "S001",
    studentName: "Aina Rahman",
    email: "aina@example.com",
    status: "Active"
};

// Normal function
function formatStudent(student) {
    return `${student.studentId} - ${student.studentName} (${student.status})`;
}

// Arrow function
const  getStudentEmail = (student) => {
    return student.email;
};

// Short arrow function
const getStudentStatus = (student) => student.status;


console.log(formatStudent(student));
console.log(getStudentEmail(student));
console.log(getStudentStatus(student));