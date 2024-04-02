package com.sonny.ea.rest.interfaces;

import com.sonny.ea.rest.models.Course;

import java.util.List;

public interface ICourseService {
    public Course getCourse(int courseId);
    public void saveCourse(Course course);

    public List<Course> getCourses();
}
