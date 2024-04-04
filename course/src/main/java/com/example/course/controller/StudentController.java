package com.example.course.controller;

import com.example.course.Domain.Course;
import com.example.course.Domain.Student;
import com.example.course.Service.CourseService;
import com.example.course.Service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;

    public StudentController(StudentService studentRepository, CourseService courseRepository) {
        this.studentService = studentRepository;
        this.courseService = courseRepository;
    }
    @PostMapping
    public void createStudent(@RequestBody Student student){
        this.studentService.createStudent(student);
    }
    @PutMapping("/{id}")
    public  void updateStudent(@PathVariable long id, @RequestBody Student student){
        this.studentService.updateStudent(id,student);
    }
    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable long id){
        return this.studentService.getStudentById(id);
    }
    @DeleteMapping("/{id}")
    public  void deleteStudent(@PathVariable long id){
        this.studentService.deleteStudent(id);
    }

    @GetMapping("/listByMajor")
    public List<Student> getStudentByMajor(@PathParam("major") String major){
        return  this.studentService.getStudentByMajor(major);
    }


    @PutMapping("/{id}/addCourse/")
    public  void addCourseToStudent(@PathVariable long id, @RequestBody Course course){
        this.studentService.addCourse(id,course);
    }

    @GetMapping("/courses/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable long id){
        return this.studentService.getCourseByStudentID(id);
    }

}
