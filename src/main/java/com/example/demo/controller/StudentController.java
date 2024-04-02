package com.example.demo.controller;

import com.example.demo.service.StudentService;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/students")
@RestController
public class StudentController {
    private final StudentService studentService;

    @GetMapping("")
    public List<Student> student() {
        return studentService.getStudents();
    }

    @PostMapping("")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/getStudentsByMajor")
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/getCoursesByStudentId/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable Long id) {
        return studentService.getCoursesByStudentId(id);
    }
}
