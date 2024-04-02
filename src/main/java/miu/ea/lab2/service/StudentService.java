package miu.ea.lab2.service;

import miu.ea.lab2.model.Course;
import miu.ea.lab2.model.Student;
import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getAll();
    Student getStudentById(Long id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(Long id);
}
