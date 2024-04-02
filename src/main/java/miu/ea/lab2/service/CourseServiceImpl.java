package miu.ea.lab2.service;

import lombok.RequiredArgsConstructor;
import miu.ea.lab2.model.Course;
import miu.ea.lab2.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements  CourseService {
    private final CourseRepository courseRepository;

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.update(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.delete(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getById(id);
    }
}
