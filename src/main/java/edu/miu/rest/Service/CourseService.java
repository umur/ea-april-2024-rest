package edu.miu.rest.Service;

import edu.miu.rest.Entity.Course;
import edu.miu.rest.Repository.CourseRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepo courseRepo;

    public List<Course> getCourses(){
        return courseRepo.getCourses();
    }

    public Course getCourse(long id ){
        return courseRepo.getCourse(id);
    }
    public void addCourse(Course course){
        courseRepo.addCourse(course);
    }

    public void updateCourse(long id, Course course){
        courseRepo.updateCourse(id, course);
    }

    public void deleteCourse(long id){
        courseRepo.deleteCourse(id);
    }
}
