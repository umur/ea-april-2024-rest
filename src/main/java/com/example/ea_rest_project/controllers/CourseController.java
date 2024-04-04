package com.example.ea_rest_project.controllers;

import com.example.ea_rest_project.domain.Course;

import com.example.ea_rest_project.dto.CourseRequest;
import com.example.ea_rest_project.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @Operation(summary = "Gets all courses", description = "This API will fetch all the courses available")
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @Operation(summary = "Gets a course by id", description = "This API will fetch a course using id")
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @Operation(summary = "Saves a course", description = "This API will save the course")
    @PostMapping
    public String saveCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
        return "Course saved successfully";
    }

    @Operation(summary = "Updates a course", description = "This API will update the course and its attributes")
    @PutMapping("/{id}")
    public String updateCourse(@PathVariable int id, @RequestBody CourseRequest courseRequest) {
        courseService.updateCourse(id, courseRequest);
        return "Course updated successfully";
    }

    @Operation(summary = "Deletes a course", description = "This API will delete a courses by the given id")
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return "Course deleted successfully";
    }

}





//    @PostMapping
//    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
//        Course savedCourse = courseService.saveCourse(course);
//        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
//    }


