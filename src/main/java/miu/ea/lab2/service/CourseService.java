package miu.ea.lab2.service;

import miu.ea.lab2.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {


    //Add new course
    Course addCourse(Course course);

    //get all courses
    List<Course> getAllCourses();

    //get course by id
    Course getCourseById(Long id);

    //Update course by id
    Course updateCourse(Course course);

    //Delete course by id
    Course deleteCourse(Long id);
}
