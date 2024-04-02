package com.sonny.ea.rest.services;

import com.sonny.ea.rest.interfaces.ICourseService;
import com.sonny.ea.rest.interfaces.IStudentService;
import com.sonny.ea.rest.models.Course;
import com.sonny.ea.rest.models.Student;
import com.sonny.ea.rest.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    private final ICourseService courseService;

    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepository.getCoursesByStudentId(studentId);
    }

    public void addCourse(int studentId, int courseId) {
        Course course = courseService.getCourse(courseId);
        Student student = studentRepository.getStudent(studentId);
        student.addCourse(course);
        studentRepository.save(student);
    }
}
