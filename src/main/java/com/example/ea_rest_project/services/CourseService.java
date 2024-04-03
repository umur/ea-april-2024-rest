package com.example.ea_rest_project.services;

import com.example.ea_rest_project.domain.Course;
import com.example.ea_rest_project.dto.CourseRequest;
import com.example.ea_rest_project.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public void saveCourse(Course course){
        if(course != null){
            courseRepository.saveCourse(course);
        }else{
            throw new NullPointerException("Course can not be empty");
        }
    }

    public List<Course> getAllCourses(){
        return courseRepository.getAllCourses();
    }

    public Course getCourseById(int id){
        return courseRepository.getCourseById(id);

    }

    public void updateCourse(int id, CourseRequest courseRequest) {
        Course course = courseRepository.getCourseById(id);

        course.setName(courseRequest.getName());
        course.setCode(courseRequest.getCode());

        courseRepository.updateCourse(course);
    }

    public void deleteCourse(int id){
        for(Course c: courseRepository.getCourseList()){
            if(c.getId() == id ){
                courseRepository.deleteCourse(c);
                return;
            }
        }
        throw new NullPointerException("Course is null");
    }

}
