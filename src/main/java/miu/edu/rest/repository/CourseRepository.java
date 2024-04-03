package miu.edu.rest.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import miu.edu.rest.entity.*;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@RequiredArgsConstructor
public class CourseRepository {

    private final StudentRepository studentRepository;

    private final List<Course> courses = new ArrayList<>();

    public Course getCourseById(Long id) {
        return courses.stream()
                .filter(s -> s.getCourseId() == id)
                .findFirst()
                .get();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void updateCourse(Long id, Course newCourse) {
        Course course = this.courses.stream()
                .filter(s -> s.getCourseId() == id)
                .findFirst()
                .get();

        int index = this.courses.indexOf(course);
        this.courses.set(index, newCourse);
    }

    public void deleteCourse(Long id) {
        Course course = this.courses.stream()
                .filter(s -> s.getCourseId() == id)
                .findFirst()
                .get();

        this.courses.remove(course);
    }

    public List<Course> getCoursesByStudentId(Long studentId) {
        Student student = studentRepository.getStudentById(studentId);

        return student.getCoursesTaken();
    }
}
