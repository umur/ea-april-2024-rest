package com.sonny.ea.rest.controllers;

import com.sonny.ea.rest.interfaces.IStudentService;
import com.sonny.ea.rest.models.Course;
import com.sonny.ea.rest.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final IStudentService studentService;

    @GetMapping("/findByMajor/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{studentId}/courses")
    public List<Course> getCourse(@PathVariable int studentId) {
        return  studentService.getCoursesByStudentId(studentId);
    }
}
