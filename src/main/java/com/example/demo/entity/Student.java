package com.example.demo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
public class Student {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String major;
    private final Double gpa;
    private final List<Course> coursesTaken;

    public static List<Student> dummyStudents() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1L, "Math", "MATH101"));
        courses.add(new Course(2L, "Physics", "PHYS101"));
        courses.add(new Course(3L, "Computer Science", "CS101"));
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "John", "Jim", "test@gmail.com", "CS", 3.5, courses));
        students.add(new Student(2L, "Jane", "Tim", "a@gmail.com", "Math", 3.0, courses));
        students.add(new Student(3L, "Alice", "David", "tes@gmail.com", "Physics", 3.2, courses));
        return students;
    }
}
