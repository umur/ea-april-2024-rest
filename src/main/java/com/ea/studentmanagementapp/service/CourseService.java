package com.ea.studentmanagementapp.service;

import com.ea.studentmanagementapp.entity.Course;
import com.ea.studentmanagementapp.pojo.request.CourseRequest;
import com.ea.studentmanagementapp.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course createCourse(CourseRequest request) {
        Course course = new Course();
        course.setName(request.name());
        course.setCode(request.code());
        return courseRepository.save(course);
    }



    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }



    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));
    }



    public Course updateCourse(Long id, CourseRequest request) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        course.setName(request.name());
        course.setCode(request.code());
        return courseRepository.save(course);
    }



    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
