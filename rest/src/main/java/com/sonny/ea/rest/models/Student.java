package com.sonny.ea.rest.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
public class Student {
    private final Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Float gpa;
    private List<Course> coursesTaken = new ArrayList<>();

    public void addCourse(Course course) {
        coursesTaken.add(course);
    }
}
