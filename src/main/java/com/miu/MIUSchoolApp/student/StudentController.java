package com.miu.MIUSchoolApp.student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/student")
@Api(value = "Student Management API", description = "Operations pertaining to student in Student Management API")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ApiOperation(value = "List Student", response = List.class)
    @GetMapping("/")
    public ResponseEntity<List<Student>> getStudents() {

        return ResponseEntity.ok(studentService.getStudents());
    }

    @ApiOperation(value = "New Student", response = String.class)
    @PostMapping("/new")
    public ResponseEntity<?> newStudent(@RequestBody Student student) {

        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @ApiOperation(value = "Update Student", response = String.class)
    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {

        return ResponseEntity.ok(studentService.updateStudent(student));
    }

    @ApiOperation(value = "Delete Student", response = String.class)
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteStudent(@RequestBody Student student) {

        return ResponseEntity.ok(studentService.deleteStudent(student));
    }

    @ApiOperation(value = "Students by Major", response = String.class)
    @PostMapping("/students-by-major")
    public ResponseEntity<?> getStudentsByMajor(@RequestBody MajorDTO majorDTO) {

        return ResponseEntity.ok(studentService.getStudentsByMajor(majorDTO));
    }

    @ApiOperation(value = "Courses by Student id", response = String.class)
    @PostMapping("/courses-by-student-id")
    public ResponseEntity<?> getCoursesByStudentId(@RequestBody StudentDTO studentDTO) {

        return ResponseEntity.ok(studentService.getCoursesByStudentId(studentDTO));
    }

}
