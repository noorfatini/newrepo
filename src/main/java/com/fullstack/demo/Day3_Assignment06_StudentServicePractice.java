package src.main.java.com.fullstack.demo;

import src.main.java.com.fullstack.demo.exception.StudentNotFoundException;
import src.main.java.com.fullstack.demo.model.Student;
import src.main.java.com.fullstack.demo.repository.InMemoryStudentRepository;
import src.main.java.com.fullstack.demo.repository.StudentRepository;
import src.main.java.com.fullstack.demo.service.StudentService;

import java.util.List;

public class Day3_Assignment06_StudentServicePractice {

    public static void main(String[] args) {

        StudentRepository studentRepository = new InMemoryStudentRepository();
        StudentService studentService = new StudentService(studentRepository);

        System.out.println("=== Register Students ===");
        Student roberto = new Student("S001", "Roberto Chan", "roberto@example.com");
        Student priya = new Student("S002", "Priya Nair", "priya@example.com");
        Student lee = new Student("S003", "Lee Salazae", "lee@example.com");

        studentService.registerStudent(roberto);
        studentService.registerStudent(priya);
        studentService.registerStudent(lee);
        System.out.println("3 students registered.");

        System.out.println("\n=== All Students ===");
        for (Student student : studentService.getAllStudents()) {
            student.printProfile();
        }

        System.out.println("\n=== Find Student By ID ===");
        Student foundStudent = studentService.getStudentById("S002");
        foundStudent.printProfile();

        System.out.println("\n=== Search Student By Name ===");
        List<Student> searchResults = studentService.searchByNameUsingLoop("lee");
        for (Student student : searchResults) {
            student.printProfile();
        }

        System.out.println("\n=== Search Student By Name (Stream) ===");
        List<Student> streamResults = studentService.searchByNameUsingStream("priya");
        for (Student student : streamResults) {
            student.printProfile();
        }

        System.out.println("\n=== Missing Student Test ===");
        try {
            studentService.getStudentById("S999");
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
