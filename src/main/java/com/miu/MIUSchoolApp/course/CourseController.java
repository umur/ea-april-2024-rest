package com.miu.MIUSchoolApp.course;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@Api(value = "Courses Management API", description = "Operations pertaining to course in Course Management API")
public class CourseController {


    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @ApiOperation(value = "View a list of available courses", response = List.class)
    @GetMapping("/")
    public ResponseEntity<List<Course>> getCourses() {

        return ResponseEntity.ok(courseService.getCourses());
    }

    @ApiOperation(value = "Add course", response = String.class)
    @PostMapping("/new")
    public ResponseEntity<?> newCourse(@RequestBody Course course) {

        return ResponseEntity.ok(courseService.addCourse(course));
    }

    @ApiOperation(value = "Update course", response = String.class)
    @PutMapping("/update")
    public ResponseEntity<?> updateCourse(@RequestBody Course course) {

        return ResponseEntity.ok(courseService.updateCourse(course));
    }

    @ApiOperation(value = "Delete course", response = String.class)
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCourse(@RequestBody Course course) {

        return ResponseEntity.ok(courseService.deleteCourse(course));
    }
}
