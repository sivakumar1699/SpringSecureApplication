package com.telusko.SpringSecEx.controller;

import com.telusko.SpringSecEx.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Shiva", 90),
            new Student(2, "Tejesh", 80)
    ));
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
