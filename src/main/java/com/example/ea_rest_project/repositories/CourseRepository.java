package com.example.ea_rest_project.repositories;

import com.example.ea_rest_project.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CourseRepository {
    private static List<Course> courseList = new ArrayList<>();


    public void saveCourse(Course course){
        courseList.add(course);
    }

    public List<Course> getAllCourses(){
        return courseList;
    }

    public Course getCourseByCode(String code){
       return courseList.stream()
                .filter(c -> c.getCode() == code)
                .findFirst().get();
    }

    public void updateCourse(Course course){
        for(Course c: courseList){
            if(c.getId().equals(course.getId())){
                c.setId(course.getId());
                c.setName(course.getName());
                c.setCode(course.getCode());
            }
        }
    }

    public void deleteCourse(Course course){
        for(Course c: courseList){
            if(c.getId().equals(course.getId())){
                courseList.remove(course);
            }
        }
    }
}
