package com.ea.studentmanagementapp.controller;

import com.ea.studentmanagementapp.entity.Course;
import com.ea.studentmanagementapp.entity.Student;
import com.ea.studentmanagementapp.pojo.request.StudentRequest;
import com.ea.studentmanagementapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;


    @PostMapping
    public Student createStudent(@RequestBody StudentRequest request){
        return studentService.createStudent(request);
    }


    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }


    @GetMapping("/search-by-major")
    public List<Student> getStudentsByMajor(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }


    @GetMapping("{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable Long id){
        return studentService.getCoursesByStudentId(id);
    }


    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody StudentRequest request){
        return studentService.updateStudent(id, request);
    }


    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}
