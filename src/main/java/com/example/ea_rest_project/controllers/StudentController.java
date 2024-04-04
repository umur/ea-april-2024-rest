package com.example.ea_rest_project.controllers;


import com.example.ea_rest_project.domain.Student;
import com.example.ea_rest_project.dto.StudentRequest;
import com.example.ea_rest_project.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;


    @Operation(summary = "Saves a student", description = "This API will save the student")
    @PostMapping
    public String saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Student saved successfully";
    }

    @Operation(summary = "Gets all students", description = "This API will fetch all the students available")
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @Operation(summary = "Gets a student by id", description = "This API will fetch a student using id")
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @Operation(summary = "Updates a student", description = "This API will update the student and its attributes")
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Integer id, @RequestBody StudentRequest studentRequest){
        studentService.updateStudent(id, studentRequest);
        return "Student updated successfully";
    }

    @Operation(summary = "Deletes a student", description = "This API will delete a student by the given id")
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }

}
