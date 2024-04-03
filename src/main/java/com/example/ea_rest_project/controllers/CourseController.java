package com.example.ea_rest_project.controllers;

import com.example.ea_rest_project.domain.Course;

import com.example.ea_rest_project.dto.CourseRequest;
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
    public Course getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public String saveCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
        return "Course saved successfully";
    }

    @PutMapping("/{id}")
    public String updateCourse(@PathVariable int id, @RequestBody CourseRequest courseRequest) {
        courseService.updateCourse(id, courseRequest);
        return "Course updated successfully";
    }

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


