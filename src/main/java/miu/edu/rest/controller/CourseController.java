package miu.edu.rest.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.rest.entity.Course;
import miu.edu.rest.entity.Student;
import miu.edu.rest.service.CourseService;
import miu.edu.rest.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAllCourses();
    }

    @GetMapping("{id}")
    public Course getById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public void add(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id,
                       @RequestBody Course course) {
        courseService.updateCourse(id, course);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @GetMapping("getByStudentId/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable Long id) {
        return courseService.getCoursesByStudentId(id);
    }

}
