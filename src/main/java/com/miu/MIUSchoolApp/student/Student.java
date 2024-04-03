package com.miu.MIUSchoolApp.student;

import com.miu.MIUSchoolApp.course.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Student {

    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private String gpa;
    private List<Course> coursesTaken;

}
