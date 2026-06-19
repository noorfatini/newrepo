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
