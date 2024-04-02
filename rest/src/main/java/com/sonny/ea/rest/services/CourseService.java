package com.sonny.ea.rest.services;

import com.sonny.ea.rest.interfaces.ICourseService;
import com.sonny.ea.rest.models.Course;
import com.sonny.ea.rest.models.Student;
import com.sonny.ea.rest.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {
    private final CourseRepository courseRepository;
    @Override
    public Course getCourse(int courseId) {
        return courseRepository.getCourse(courseId);
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.getAll();
    }

    public void updateCourse(int courseId, Course course) {
        courseRepository.updateCourse(courseId,course);
    }

    public Course deleteCourse(int courseId) {
        return courseRepository.deleteCourse(courseId);
    }
}
