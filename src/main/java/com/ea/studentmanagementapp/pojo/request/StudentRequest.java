package com.ea.studentmanagementapp.pojo.request;

import lombok.Data;

import java.util.List;

@Data
public class StudentRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;
    private List<Long> idsOfCoursesTaken;


}
