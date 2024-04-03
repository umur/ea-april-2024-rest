package miu.edu.rest.service;

import lombok.RequiredArgsConstructor;
import miu.edu.rest.entity.Student;
import miu.edu.rest.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.getStudents();
    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void updateStudent(Long id, Student student) {
        studentRepository.updateStudent(id, student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }
}
