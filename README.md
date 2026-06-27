## Day 1 Exercise 01 - Code Explanation

### 1. What is the purpose of Course.java?

Course.java is a class that represents a course. It holds information like the course ID, title, duration, level, and instructor. It is the same idea as a class in JavaScript where we define what a course object looks like.

### 2. What is the purpose of Instructor.java?

Instructor.java is a class that represents an instructor. It stores the instructor ID, name, and area of expertise. It also has a method called printProfile that prints those details to the console.

### 3. What is the purpose of Student.java?

Student.java is a class to represent a student.

### 4. What does the constructor do?

The constructor runs when we create a new object. It takes in the values we pass and saves them into the object's fields. It is the same as a constructor in JavaScript classes or in C++.

### 5. Why are the fields marked as private?

Private means other classes cannot read or change the fields directly. You have to use getter and setter methods instead. This keeps the data safe and controlled, which is the same concept as private in C++.

### 6. What does course1.assignInstructor(instructor1) mean?

This connects an Instructor object to a Course object. After calling this, the course knows which instructor is teaching it.

### 7. What does student1.printProfile() do?

It calls a method on the student object that prints the student's details to the console.

## AI-Assisted Task

Prompt I used: Explain this Java class to someone who already knows JavaScript and C++.

### 1. One explanation from AI that helped me

AI explained that Java classes work the same way as classes in JavaScript. We have a constructor, fields, and methods. The main difference is Java is stricter because you have to declare the data type for every field. That comparison was easy to understand since I already know how JS classes work.

### 2. One part I still needed the trainer or my own reading to understand

AI briefly mentioned the this keyword but did not explain it well enough. I needed the trainer to explain that we write this.courseId = courseId because the parameter name and the field name are the same. Java uses this to refer to the field, not the parameter. In C++ it is similar but we use this with an arrow instead of a dot.



## Day 1 Exercise 02 - Code Explanation

I added two new fields to the Course class which are category and active. The category field stores what type of course it is and the active field stores whether the course is currently running or not. I also updated the constructor to accept these two new values when creating a course object. Lastly I updated the printSummary method to print the category and to show the word Active or Inactive instead of printing true or false directly.

## Day 1 Exercise 03 - Code Explanation

Course only stores the general information about a course like the title, level, and duration. But in a real application, the same course can run multiple times with different instructors, dates, and class sizes. CourseOffering handles that by linking a Course to a specific scheduled run. So instead of duplicating the course data every time, we just create a new offering that points to the same course. This makes the data cleaner and easier to manage.

Note: I used AI to help check my answers and code for Exercise 02 and Exercise 03 and make sure it runs successfully.



## Day 4 Exercise 01 - JavaScript Student Object

I created a student object using curly braces without writing a class. The object has four properties which are studentId, studentName, email, and status. I printed the whole object first and then printed each property one by one. I used dot notation for studentId, studentName, and status. I used bracket notation for email.

### What is one difference between a Java object and a JavaScript object?

In Java, you must define a class first and then use the new keyword to create an object from that class. In JavaScript, you can create an object directly using curly braces without writing a class at all. This means JavaScript lets you represent simple data much faster with less code.



## Day 4 Exercise 02 - Instructor Array and Loop

I created an array called instructors that holds four instructor objects. Each object has three properties which are instructorId, instructorName, and expertise. I used a for...of loop to go through each instructor and print their details in one line. I also printed the total number of instructors using the length property.

### How is a JavaScript array similar to Java ArrayList?

Both JavaScript arrays and Java ArrayList can grow in size, meaning you do not need to set a fixed length when you create them. You can keep adding objects into them. In Java you would write List<Instructor> instructors = new ArrayList<>() and then use add() to put objects in. In JavaScript you just use square brackets and put the objects directly inside. The for...of loop in JavaScript also works the same way as the enhanced for loop in Java, where you go through each item one by one without needing an index number.



## Day 4 Exercise 03 - Functions and Arrow Functions

I wrote three types of functions for a student object. The first is a normal function called formatStudent that returns a formatted string with the student ID, name, and status. The second is an arrow function called getStudentEmail that returns the student email. The third is a short arrow function called getStudentStatus that returns the status in one line without using the return keyword.

### Why are arrow functions important before learning React?

Arrow functions are important before learning React because React uses them almost everywhere. When you write a React component, you often pass functions as props or write callback functions inside JSX. Arrow functions are shorter and cleaner to write in those situations. They also handle the this keyword differently from normal functions, which avoids common bugs when working with events and state in React. Learning arrow functions now means the React syntax will feel familiar instead of confusing when you get there.
