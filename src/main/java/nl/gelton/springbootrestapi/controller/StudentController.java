package nl.gelton.springbootrestapi.controller;

import nl.gelton.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student getStudentById(@PathVariable("id") int studentId,
                                  @PathVariable("first-name") String firstName,
                                  @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    // Spring boot REST API with request Param
    // http://localhost:8080/students/query?id=1&firstName=Oldert

    @GetMapping("/students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName) {
        return new Student(id, firstName, "Gelton");
    }
}
