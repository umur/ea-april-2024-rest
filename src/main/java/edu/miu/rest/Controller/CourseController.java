package edu.miu.rest.Controller;

import edu.miu.rest.Entity.Course;
import edu.miu.rest.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/courses")
@RequiredArgsConstructor
@RestController
public class CourseController {
   private final CourseService courseService;


    @GetMapping
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable long id){
        return courseService.getCourse(id);
    }

    @PostMapping
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable long id, @RequestBody Course course){
        courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable long id){
        courseService.deleteCourse(id);
    }
}
