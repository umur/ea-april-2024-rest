package com.example.demo.repository;

import com.example.demo.entity.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CourseRepo {
    private List<Course> courses;

    public List<Course> getCourse() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Course updateCourse(Long id, Course course) {
        for (int i = 0; i < courses.size(); i++) {
            Course crs = courses.get(i);
            if (crs.getId() == id) {
                courses.set(i, course); // Replace the existing object with the new one
                return course;
            }
        }
        return null;
    }
}
