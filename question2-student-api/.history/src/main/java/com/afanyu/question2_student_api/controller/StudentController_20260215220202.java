package com.afanyu.question2_student_api.controller;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afanyu.question2_student_api.models.Student;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1L, "Alice", "Smith", "alice@edu.com", "Computer Science", 3.8));
        students.add(new Student(2L, "Bob", "Jones", "bob@edu.com", "Mathematics", 3.2));
        students.add(new Student(3L, "Charlie", "Brown", "charlie@edu.com", "Computer Science", 3.5));
        students.add(new Student(4L, "Diana", "Prince", "diana@edu.com", "Physics", 3.9));
        students.add(new Student(5L, "Ethan", "Hunt", "ethan@edu.com", "Business", 2.8));
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return students;
    }

    @GetMapping("/{studentsId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId)
}
