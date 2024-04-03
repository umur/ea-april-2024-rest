package com.example.ea_rest_project.controllers;


import com.example.ea_rest_project.domain.Student;
import com.example.ea_rest_project.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{Students}")
public class StudentController {

    private StudentService studentService;


    @PostMapping
    public String saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Student save successfully";
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PutMapping
    public String updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return "Student updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }

}
