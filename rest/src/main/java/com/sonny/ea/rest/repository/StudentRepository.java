package com.sonny.ea.rest.repository;

import com.sonny.ea.rest.models.Course;
import com.sonny.ea.rest.models.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public Student getStudent(int studentId) {
        return students.stream()
                .filter(student -> student.getId() == studentId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + studentId));
    }

    public void save(Student student) {
        int index = students.indexOf(student);
        if (index >= 0) {
            students.set(index, student);
        } else {
            students.add(student);
        }
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(student -> student.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return new ArrayList<>(students.stream()
                .filter(student -> student.getId() == studentId)
                .findFirst()
                .map(Student::getCoursesTaken)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + studentId)));
    }
}
