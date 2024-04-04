package com.example.course.Service;


import com.example.course.Domain.Course;
import com.example.course.Repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    private CourseRepository courseRepostory;

    public CourseService(CourseRepository courseRepostory) {
        this.courseRepostory = courseRepostory;
    }

    public void addCourse(Course course){
         this.courseRepostory.addCourse(course);
    }
    public  void updateCourse(long id, Course course){
        this.courseRepostory.updateCourse(id,course);
    }
    public Optional<Course> getCourseById(long id){
        return this.courseRepostory.getcourse(id);
    }
    public void  delteCourse(long id){
        this.courseRepostory.deleteCOurse(id);
    }
}
