package com.sonny.ea.rest.controllers;

import com.sonny.ea.rest.interfaces.ICourseService;
import com.sonny.ea.rest.models.Course;
import com.sonny.ea.rest.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final ICourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
       return courseService.getCourses();
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourse(@PathVariable int courseId) {
        Course course = courseService.getCourse(courseId);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public void addCourse(Course course) {
        courseService.saveCourse(course);
    }

    @PutMapping("/{courseId}")
    public void updateCourse(@PathVariable int courseId,@RequestBody Course course) {
        courseService.updateCourse(courseId, course);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable int courseId) {
        Course course = courseService.deleteCourse(courseId);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
