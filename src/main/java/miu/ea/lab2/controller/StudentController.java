package miu.ea.lab2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import miu.ea.lab2.model.Course;
import miu.ea.lab2.model.Student;
import miu.ea.lab2.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for student entity",
        description = "CRUD REST APIs: Create student, update student, delete student, " +
                "get all students, get student by Id, get students by major, get courses by student id"
)
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @Operation(
        summary = "Get all students API"
    )
    @ApiResponse(
        description = "All students"
    )
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    @Operation(
            summary = "Create a student API"
    )
    @PostMapping
    public void createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @Operation(
            summary = "Update a student API"
    )
    @PutMapping()
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @Operation(
            summary = "Delete a student API"
    )
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @Operation(
            summary = "Get a student by Id API"
    )
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @Operation(
            summary = "Get students by major API"
    )
    @GetMapping("/major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }

    @Operation(
            summary = "Get courses of a student API"
    )
    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable Long id) {
        return studentService.getCoursesByStudentId(id);
    }
}
