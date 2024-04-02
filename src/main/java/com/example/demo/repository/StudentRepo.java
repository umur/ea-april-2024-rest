package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class StudentRepo {
    private List<Student> students = Student.dummyStudents();

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student updateStudent(Long id, Student student) {
        for (int i = 0; i < students.size(); i++) {
            Student std = students.get(i);
            if (std.getId() == id) {
                students.set(i, student); // Replace the existing object with the new one
                break; // Exit the loop once the replacement is done
            }
        }
        return null;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void deleteStudent(Long id) {
        for (int i = 0; i < students.size(); i++) {
            Student std = students.get(i);
            if (std.getId() == id) {
                students.remove(i); // Remove the existing object with the new one
                break; // Exit the loop once the replacement is done
            }
        }
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream().filter(student -> student.getMajor().toLowerCase().equals(major.toLowerCase())).toList();
    }

    public List<Course> getCoursesByStudentId(Long id) {
        return
                students.stream().filter(student -> student.getId() == id)
                        .map(Student::getCoursesTaken)
                        .flatMap(List::stream)
                        .toList();
    }
}
