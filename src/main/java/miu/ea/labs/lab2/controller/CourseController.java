package miu.ea.labs.lab2.controller;

import lombok.RequiredArgsConstructor;
import miu.ea.labs.lab2.model.Course;
import miu.ea.labs.lab2.model.Student;
import miu.ea.labs.lab2.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final StudentService studentService;

    @GetMapping("/{studentId}")
    public List<Course> getCoursesByStudentId(@PathVariable Long studentId) throws Exception{
        return studentService.getCoursesByStudentId(studentId);
    }
}
