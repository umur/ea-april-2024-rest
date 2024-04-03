package miu.ea.rest.service;

import lombok.RequiredArgsConstructor;
import miu.ea.rest.entity.Course;
import miu.ea.rest.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public Boolean create(Course course) {
        return courseRepository.create(course);
    }

    public List<Course> getAll() {
        return courseRepository.getAllCourses();
    }

    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }

    public Course update(Long id, Course CourseDetails) {
        return courseRepository.update(id, CourseDetails);
    }

    public boolean deleteCourseById(Long id) {
        return courseRepository.deleteCourseById(id);
    }
}