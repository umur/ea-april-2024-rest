package miu.ea.lab2.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import miu.ea.lab2.model.Course;
import miu.ea.lab2.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for course entity",
        description = "CRUD REST APIs: Create course, update course, delete course, get all courses, get course by Id"
)
@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAll();
    }

    @PostMapping
    public void createCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
    }

    @PutMapping()
    public void updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }
}
