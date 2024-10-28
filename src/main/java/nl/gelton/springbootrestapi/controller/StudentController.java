package nl.gelton.springbootrestapi.controller;

import nl.gelton.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
