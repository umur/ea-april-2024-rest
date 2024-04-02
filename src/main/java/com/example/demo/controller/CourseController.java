package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/courses")
@RestController
class CourseController {
    private final CourseService courseService;

    @GetMapping("")
    public List<Course> course() {
        return courseService.getCourse();
    }

    @PostMapping("")
    public void addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@RequestParam Long id, @RequestBody Course course) {
        courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@RequestParam Long id) {
        courseService.deleteCourse(id);
    }
}
