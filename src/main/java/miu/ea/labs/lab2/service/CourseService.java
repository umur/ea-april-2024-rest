package miu.ea.labs.lab2.service;

import lombok.RequiredArgsConstructor;
import miu.ea.labs.lab2.model.Course;
import miu.ea.labs.lab2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final StudentRepository studentRepository;
    public List<Course> getCoursesByStudentId(Long studentId) throws Exception{
        return studentRepository.findStudent(studentId).getCoursesTaken();
    }
}
