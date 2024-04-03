package com.example.Rest.lab.Service;

import com.example.Rest.lab.Entity.Course;
import com.example.Rest.lab.Repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepo repo;

    public void addCourse(Course course) {
        repo.addCourse(course);
    }

    public List<Course> getAllCourses() {
        return repo.getCourses();
    }

    public Course getCourseById(long id) {
        return repo.getCourseById(id);
    }

    public void updateCourse(Course updatedCourse, long id) {
        repo.updateCourse(updatedCourse, id);
    }

    public void deleteCourse(long id) {
        repo.deleteCourse(id);
    }
}
