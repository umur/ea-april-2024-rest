package com.example.ea_rest_project.dto;

import com.example.ea_rest_project.domain.Course;
import lombok.Data;

import java.util.List;

@Data
public class StudentRequest {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;
    private List<Course> coursesTaken;
}
