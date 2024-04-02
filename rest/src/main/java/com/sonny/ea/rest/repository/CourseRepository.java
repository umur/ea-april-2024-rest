package com.sonny.ea.rest.repository;

import com.sonny.ea.rest.models.Course;
import com.sonny.ea.rest.models.Student;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public  List<Course> getAll() {
        return courses;
    }

    public Course getCourse(int courseId) {
        return courses.stream()
                .filter(course -> course.getId() == courseId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + courseId));

    }

    public void save(Course course) {
        int index = courses.indexOf(course);
        if (index >= 0) {
            courses.set(index, course);
        } else {
            courses.add(course);
        }
    }

    public void updateCourse(int courseId, Course course) {
        Course exist = getCourse(courseId);
        if (exist != null) {
            int index = courses.indexOf(exist);
            courses.set(index, course);
        }
    }

    public Course deleteCourse(int courseId) {
        Course exist = getCourse(courseId);
        if (exist != null) {
            courses.remove(exist);
        }
        return exist;
    }
}
