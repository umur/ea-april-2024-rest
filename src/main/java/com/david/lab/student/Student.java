package com.david.lab.student;

import com.david.lab.course.Course;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String gpa;
    private List<Course> coursesTaken;
}