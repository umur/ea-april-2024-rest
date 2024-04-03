package com.example.Rest.lab.Repository;

import com.example.Rest.lab.Entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private List<Course> courseList = new ArrayList<>();

    public void addCourse(Course c){
        courseList.add(c);
    }

    public List<Course> getCourses(){
        return courseList;
    }

    public Course getCourseById(long id){
        return courseList.stream()
                .filter(l->l.getId()== id)
                .findFirst()
                .get();
    }

    public void updateCourse(Course c , long id){
        Course x = getCourseById(id);
        x.setId(c.getId());
        x.setCode(c.getCode());
        x.setName(c.getName());
    }

    public void deleteCourse(long id){
        courseList.removeIf(c->c.getId()==id);
    }
}
