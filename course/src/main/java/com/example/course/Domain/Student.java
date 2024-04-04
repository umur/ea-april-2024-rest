package com.example.course.Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    private List<Course> courseTaken;


    public Student(long id, String firstName, String lastName, String email, String major, double gpa, List<Course> courseTaken) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
        this.courseTaken = courseTaken;
    }

    public Student() {
        this.courseTaken = new ArrayList<>();

    }
    public void addCourse(Course course){
        this.courseTaken.add(course);
    }
}
