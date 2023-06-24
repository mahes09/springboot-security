package com.spring.springbootsecurity.controller;

import com.spring.springbootsecurity.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>();

    @GetMapping("/students")
    public List<Student> students() {
        List<Student> students =new ArrayList<>();
        Student student1 = new Student();
        student1.setId(1);
        student1.setFirstName("ram");
        student1.setLastName("kumar");

        Student student2 = new Student();
        student2.setId(2);
        student2.setFirstName("mahi");
        student2.setLastName("ram");

        students.add(student1);
        students.add(student2);
        return students;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}

