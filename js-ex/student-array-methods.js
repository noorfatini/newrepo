const students = [
  {
    studentId: "S001",
    studentName: "Ignacio de Paul",
    email: "ignacio@example.com",
    status: "Active",
  },
  {
    studentId: "S002",
    studentName: "Ben Tan",
    email: "ben@example.com",
    status: "Inactive",
  },
  {
    studentId: "S003",
    studentName: "Chong Mei",
    email: "mei@example.com",
    status: "Active",
  },
];

// Part A
// original students array
console.log("=== Original Students ===");
console.log(students);
console.log();


// forEach - Print all student names
console.log("=== All Student Names ===");
students.forEach((student) => {
    console.log(student.studentName);
});
console.log();


// filter - create new array (only Active students)
console.log("=== Active Students ===");
const activeStudents = students.filter((student) => student.status === "Active");
console.log(activeStudents);
console.log();


// find - find student with ID S002
console.log("=== Find Student S002 ===");
const foundStudent = students.find((student) => student.studentId === "S002");
console.log(foundStudent);
console.log();

// map - create new array (only student emails)
console.log("=== Student Emails ===");
const studentEmails = students.map((student) => student.email);
console.log(studentEmails);
console.log();


// Part B
// push - add 1 new student to the end of the array
console.log("=== After push ===");
const newLengthAfterPush = students.push({
    studentId: "S004",
    studentName: "Danish Nawaz",
    email: "danish@example.com",
    status: "Active"
});
console.log(students);
console.log("New length after push:", newLengthAfterPush);
console.log();


// pop - remove last student from the array
console.log("=== After pop ===");
const removedLastStudent = students.pop();
console.log(students);
console.log("Removed last student:\n", removedLastStudent);
console.log();


// unshift - add 1 new student to the beginning of the array
console.log("=== After unshift ===");
const newLengthAfterUnshift = students.unshift({
    studentId: "S000",
    studentName: "Ignacio de Paul",
    email: "ignacio@example.com",
    status: "Active"
});
console.log(students);
console.log("New length after unshift:", newLengthAfterUnshift);
console.log();


// shift - remove first student from the array
console.log("=== After shift ===");
const removedFirstStudent = students.shift();
console.log(students);
console.log("Removed first student:\n", removedFirstStudent);
console.log();


// final students array
console.log("=== Final Students Array ===");
console.log(students);