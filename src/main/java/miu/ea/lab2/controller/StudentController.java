package miu.ea.lab2.controller;

import lombok.RequiredArgsConstructor;
import miu.ea.lab2.entity.Course;
import miu.ea.lab2.entity.Student;
import miu.ea.lab2.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RequestMapping("/students")
@RestController

@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    //CRUD Controller
    //Add Student
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody  Student student){
        Student result = studentService.addStudent(student);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    //Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> result = studentService.getAllStudents();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    //Get Student by id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student result = studentService.getStudentById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    //Update student
    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student result = studentService.updateStudent(student);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    //delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        Student result = studentService.deleteStudent(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    //GET STUDENT BY MAJOR
    @GetMapping("/major")
    public ResponseEntity<List<Student>> getStudentByMajor(@RequestParam String major){
        List<Student> results = studentService.getStudentsByMajor(major);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(results);
    }

    //GET Courses by Student ID
    @GetMapping("/courses/{id}")
    public ResponseEntity<List<Course>> getCourseByStudentId(@PathVariable Long id){
        List<Course> results = studentService.getCourseByStudentId(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(results);
    }

}
