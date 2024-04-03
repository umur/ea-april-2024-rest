package miu.ea.lab2.service;

import lombok.RequiredArgsConstructor;
import miu.ea.lab2.entity.Course;
import miu.ea.lab2.entity.Student;
import miu.ea.lab2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    @Override
    public Student deleteStudent(Long id) {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCourseByStudentId(Long id) {
        return studentRepository.getCourseByStudentId(id);
    }
}
