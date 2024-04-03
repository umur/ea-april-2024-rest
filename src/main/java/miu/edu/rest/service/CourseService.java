package miu.edu.rest.service;

import lombok.RequiredArgsConstructor;
import miu.edu.rest.entity.Course;
import miu.edu.rest.entity.Student;
import miu.edu.rest.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.getCourses();
    }

    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }

    public void addCourse(Course course) {
        courseRepository.addCourse(course);
    }

    public void updateCourse(Long id, Course course) {
        courseRepository.updateCourse(id, course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteCourse(id);
    }

    public List<Course> getCoursesByStudentId(Long studentId) {
        return courseRepository.getCoursesByStudentId(studentId);
    }
}
