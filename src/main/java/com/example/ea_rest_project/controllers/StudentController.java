package com.example.ea_rest_project.controllers;


import com.example.ea_rest_project.domain.Student;
import com.example.ea_rest_project.dto.StudentRequest;
import com.example.ea_rest_project.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;


    @PostMapping
    public String saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Student saved successfully";
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Integer id, @RequestBody StudentRequest studentRequest){
        studentService.updateStudent(id, studentRequest);
        return "Student updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }

}
