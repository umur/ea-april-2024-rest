package miu.ea.rest.service;

import miu.ea.rest.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import miu.ea.rest.entity.Student;
import miu.ea.rest.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student create(Student student) {
        return studentRepository.create(student);
    }

    public List<Student> getAll() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    public Student update(Long id, Student studentDetails) {
        return studentRepository.update(id, studentDetails);
    }

    public boolean deleteStudentById(Long id) {
        return studentRepository.deleteStudentById(id);
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    public List<Course> getCoursesByStudentId(Long studentId) {
        return studentRepository.getCoursesByStudentId(studentId);
    }
}