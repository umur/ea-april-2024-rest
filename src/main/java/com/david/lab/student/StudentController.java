package com.david.lab.student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Student Controller", description = "APIs related to student operations")
@RequiredArgsConstructor
@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @Operation(summary = "View a list of all students with specific major", description = "This API fetches all the students with specific major available in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Students by major fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("major/{major}")
    public ResponseEntity<List<Student>> getStudentsByMajor(@PathVariable @Parameter(example = "Computer Science") String major) {
        return ResponseEntity.ok(studentService.getStudentsByMajor(major));
    }

    @Operation(summary = "View a list of all students", description = "This API fetches all the students available in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Students fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Operation(summary = "Get a student by Id", description = "This API fetches a specific student by its unique identifier.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable @Parameter(example = "1") long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Add a student", description = "This API adds a new student to the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @Operation(summary = "Update a student", description = "This API updates an existing student in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student updated successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable @Parameter(example = "1") long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.updateStudent(student)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a student", description = "This API deletes an existing student from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Student deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable @Parameter(example = "1") long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}