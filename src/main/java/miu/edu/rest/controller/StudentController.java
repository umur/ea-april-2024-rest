package miu.edu.rest.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.rest.entity.Student;
import miu.edu.rest.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void add(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id,
                       @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("getByMajor")
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

}
