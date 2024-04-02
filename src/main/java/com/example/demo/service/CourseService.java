package com.example.demo.service;

import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.StudentRepo;
import com.example.demo.entity.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {
    private List<Course> courses;

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void deleteCourse(Long id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.remove(i);
                break;
            }
        }
    }

    public void updateCourse(Long id, Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.set(i, course);
                break;
            }
        }
    }

    public List<Course> getCourse() {
        return courses;
    }
}
