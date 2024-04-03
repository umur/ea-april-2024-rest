package miu.ea.lab2.service;

import lombok.RequiredArgsConstructor;
import miu.ea.lab2.entity.Course;
import miu.ea.lab2.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseImpl implements CourseService{

    private final CourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.addCourse(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCoures();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.updateCourse(course);
    }

    @Override
    public Course deleteCourse(Long id) {
        return courseRepository.deleteCourse(id);
    }
}
