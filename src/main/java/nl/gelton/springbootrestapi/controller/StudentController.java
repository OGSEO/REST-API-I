package nl.gelton.springbootrestapi.controller;

import nl.gelton.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "Ollie",
                "Gelton"
        );
        return student;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ollie", "Gelton"));
        students.add(new Student(2, "Manolo", "Gelton"));
        students.add(new Student(3, "Sharona", "Thonhauser"));
        students.add(new Student(4, "Santino", "Hendriks"));
        return students;
    }

    // {id} - URI template variable

    @GetMapping("students/{id}")
    public Student getStudentById(@PathVariable("id") int studentId) {
        return new Student(studentId, "Ollie", "Gelton");
    }
}
