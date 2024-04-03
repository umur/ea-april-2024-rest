package com.example.Rest.lab.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;

    private List<Course> coursesTaken;

    public Student(){
        this.coursesTaken = new ArrayList<Course>();
    }

    public void addCourse( Course c){
        coursesTaken.add(c);
    }
}
