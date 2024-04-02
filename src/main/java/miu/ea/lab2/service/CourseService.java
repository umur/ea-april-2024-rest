package miu.ea.lab2.service;


import miu.ea.lab2.model.Course;

import java.util.List;

public interface CourseService {
    void saveCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getAll();
    Course getCourseById(Long id);
}
