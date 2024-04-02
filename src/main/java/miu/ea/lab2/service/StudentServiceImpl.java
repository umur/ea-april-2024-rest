package miu.ea.lab2.service;

import lombok.RequiredArgsConstructor;
import miu.ea.lab2.model.Course;
import miu.ea.lab2.model.Student;
import miu.ea.lab2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements  StudentService {
    private final StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.update(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(Long id) {
        return studentRepository.getCoursesById(id);
    }
}
