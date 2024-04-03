package com.brianmugalu.labTwo.repository;

import com.brianmugalu.labTwo.repository.models.Course;
import com.brianmugalu.labTwo.repository.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private final ArrayList<Student> studentList;

    public void addStudent(Student student){
        studentList.add(student);
    }
    public void removeStudent(int id){
        studentList.removeIf(student -> student.getId()== id);
    }


    public List<Student> getStudentsByMajor(String major){
        return studentList.stream()
                .filter(student->student.getMajor().equals(major))
                .toList();
    }

    public List<Course> getCoursesByStudentId(int studentId){
        return studentList.stream()
                .filter(student -> student.getId()==studentId)
                .map(Student::getCoursesTaken)
                .flatMap(List::stream) // Convert stream of collections to a single stream
                .toList();
    }

    public void addCourses(int id, List<Course> courses) {
        studentList.stream()
                .filter(student -> student.getId() == id)
                .forEach(student -> student.setCoursesTaken(courses));
    }
}


