package com.example.ea_rest_project.repositories;

import com.example.ea_rest_project.domain.Course;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
@Data
public class CourseRepository {
    private List<Course> courseList = new ArrayList<>();


    public void saveCourse(Course course){
        courseList.add(course);
    }

    public List<Course> getAllCourses(){
        return courseList;
    }

    public Course getCourseById(String id){
       return courseList.stream()
                .filter(c -> c.getId() == id)
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
        courseList.remove(course);
    }
}
