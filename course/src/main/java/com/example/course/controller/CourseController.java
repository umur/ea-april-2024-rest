package com.example.course.controller;

import com.example.course.Domain.Course;
import com.example.course.Service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public void createCourse(@RequestBody Course course){
        this.courseService.addCourse(course);
    }
    @DeleteMapping("/{id}")
    public  void  deleteCOurse(@PathVariable long id){
        this.courseService.delteCourse(id);
    }
    @PutMapping("/{id}")
    public  void updateCourse(@PathVariable long id, @RequestBody Course course){
        this.courseService.updateCourse(id,course);
    }
    @GetMapping("/{id}")
    public Optional<Course> getCourse(@PathVariable long id){
      return  this.courseService.getCourseById(id);
    }

}
