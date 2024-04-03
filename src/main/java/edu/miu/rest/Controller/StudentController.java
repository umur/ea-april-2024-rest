package edu.miu.rest.Controller;

import edu.miu.rest.Entity.Course;
import edu.miu.rest.Entity.Student;
import edu.miu.rest.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
        private final StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
       return studentService.getStudents();
    }

    @PostMapping
    public void addStudents(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudents(@PathVariable long id, @RequestBody Student student){
        studentService.updateStudents(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/{major}")
    public List<Student> getAllStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable long id){
        return studentService.getCoursesByStudentId(id);
    }
}
