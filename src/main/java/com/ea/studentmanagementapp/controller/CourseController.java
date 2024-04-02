package com.ea.studentmanagementapp.controller;

import com.ea.studentmanagementapp.entity.Course;
import com.ea.studentmanagementapp.pojo.request.CourseRequest;
import com.ea.studentmanagementapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;


    @PostMapping
    public Course createCourse(@RequestBody CourseRequest request){
        return courseService.createCourse(request);
    }


    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }


    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }


    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody CourseRequest request){
        return courseService.updateCourse(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }

}
