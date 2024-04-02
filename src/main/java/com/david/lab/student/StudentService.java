package com.david.lab.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getAllStudents()
                .stream()
                .filter(student -> student.getMajor().equalsIgnoreCase(major))
                .toList();
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Optional<Student> getStudentById(long id) {
        return studentRepository.getStudentById(id);
    }

    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Optional<Student> updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteStudent(id);
    }
}