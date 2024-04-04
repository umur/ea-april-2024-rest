package com.example.course.Repository;

import com.example.course.Domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class CourseRepository {

    private List<Course> listCourse= new ArrayList<>();

    public void  addCourse(Course course){
        listCourse.add(course);
    }
    public Optional<Course> getcourse(Long id){
        return this.listCourse.stream().filter(c->c.getId()==id).findFirst();
    }
    public void updateCourse(long id, Course course){
        Optional<Course> courseOld=  getcourse(id);
        courseOld.ifPresent(o -> {
            int i = this.listCourse.indexOf(o);
            this.listCourse.set(i, course);
        });
    }
    public void  deleteCOurse(long id){
        Optional<Course> couseDelete = getcourse(id);
        couseDelete.ifPresent(d->listCourse.remove(d));
    }

}
