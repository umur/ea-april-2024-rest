package com.david.lab.course;

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

@Tag(name = "Course Controller", description = "APIs related to course operations")
@RequiredArgsConstructor
@RestController
@RequestMapping("course")
public class CourseController {

    private final CourseService courseService;

    @Operation(summary = "Returns all courses of the student", description = "This API fetches all the courses of the student.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student courses fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("student/{id}")
    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable @Parameter(example = "1") long id) {
        return courseService.getCoursesByStudentId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "View a list of all courses", description = "This API fetches all the courses available in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Courses fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @Operation(summary = "Get a course by Id", description = "This API fetches a specific course by its unique identifier.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Course not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable @Parameter(example = "1") long id) {
        return courseService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Add a course", description = "This API adds a new course to the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Course created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course savedCourse = courseService.addCourse(course);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a course", description = "This API updates an existing course in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course updated successfully"),
            @ApiResponse(responseCode = "404", description = "Course not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable @Parameter(example = "1") long id, @RequestBody Course course) {
        course.setId(id);
        return courseService.updateCourse(course)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a course", description = "This API deletes an existing course from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Course deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Course not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable @Parameter(example = "1") long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}