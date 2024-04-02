package miu.ea.labs.lab2.controller;

import lombok.RequiredArgsConstructor;
import miu.ea.labs.lab2.model.Course;
import miu.ea.labs.lab2.model.Student;
import miu.ea.labs.lab2.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/find-by-major")
    public List<Student> getStudentsByMajor(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping
    public Collection<Student> getAllStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{studentId}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable Long studentId) throws Exception{
        return studentService.getCoursesByStudentId(studentId);
    }
}
