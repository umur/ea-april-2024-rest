package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public List<Student> getStudents() {
        return studentRepo.getStudents();
    }

    public void addStudent(Student student) {
        Student newStudent = new Student(student.getId(), student.getFirstName(), student.getLastName(),
        student.getEmail(), student.getMajor(), student.getGpa(), student.getCoursesTaken());
        studentRepo.addStudent(newStudent);
    }

    public Student updateStudent(Long id, Student student) {
        return studentRepo.updateStudent(id, student);
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteStudent(id);
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    public List<Course> getCoursesByStudentId(Long id) {
        return studentRepo.getCoursesByStudentId(id);
    }
}
