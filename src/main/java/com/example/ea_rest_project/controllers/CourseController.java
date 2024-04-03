package com.example.ea_rest_project.controllers;

import com.example.ea_rest_project.domain.Course;
import com.example.ea_rest_project.services.CourseService;
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

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable String id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public String saveCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
        return "Course saved successfully";
    }

    @PutMapping
    public String updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
        return "Course updated successfully";
    }

    @DeleteMapping
    public String deleteCourse(@RequestBody Course course) {
        courseService.deleteCourse(course);
        return "Course deleted successfully";
    }

}





//    @PostMapping
//    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
//        Course savedCourse = courseService.saveCourse(course);
//        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
//    }


