package miu.ea.lab2.controller;

import lombok.RequiredArgsConstructor;
import miu.ea.lab2.entity.Course;
import miu.ea.lab2.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/courses")
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    //CREATE NEW COURSE
    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Course addedCourse =  courseService.addCourse(course);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addedCourse);

    }

    //GET LIST OF COURSES
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> results =  courseService.getAllCourses();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(results);
    }

    //GET COURSE BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id){
        Course result =  courseService.getCourseById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    //UPDATE COURSE BY ID
    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody Course updateCourse){
        Course result =  courseService.updateCourse(updateCourse);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    //DELETE COURSE BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Long id){
        Course result =  courseService.deleteCourse(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }
}
