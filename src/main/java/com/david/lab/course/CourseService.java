package com.david.lab.course;

import com.david.lab.student.Student;
import com.david.lab.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentService studentService;

    public Optional<List<Course>> getCoursesByStudentId(long studentId) {
        return studentService.getStudentById(studentId)
                .map(Student::getCoursesTaken);
    }

    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    public Optional<Course> getCourseById(long id) {
        return courseRepository.getCourseById(id);
    }

    public Course addCourse(Course course) {
        return courseRepository.addCourse(course);
    }

    public Optional<Course> updateCourse(Course course) {
        return courseRepository.updateCourse(course);
    }

    public void deleteCourse(long id) {
        courseRepository.deleteCourse(id);
    }
}