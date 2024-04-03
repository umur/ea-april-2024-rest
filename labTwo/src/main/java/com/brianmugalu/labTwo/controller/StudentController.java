package com.brianmugalu.labTwo.controller;

import com.brianmugalu.labTwo.repository.models.Course;
import com.brianmugalu.labTwo.repository.models.Student;
import com.brianmugalu.labTwo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @PostMapping
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public String removeStudent(@PathVariable int id){
        return studentService.removeStudent(id);
    }
    @GetMapping("/major")
    public  List<Student> getStudentByMajor(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }

    @PutMapping("update/{id}")
    public Student updateMajor(@PathVariable int id, @RequestBody String major){
        return studentService.updateMajor(id,major);
    }

    @GetMapping("courses/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable int id){
        return studentService.getCoursesByStudentId(id);
    }
    @PostMapping("/courses/{id}")
    public String addCourses(@PathVariable int id,@RequestBody List<Course> courses){
        return studentService.addCourses(id,courses);
    }
}
