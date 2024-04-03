package miu.ea.lab2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Student {

//    Make a domain model Student with id, firstName, lastName, email, major, gpa, and coursesTaken

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String gpa;
    private List<Course> listCoursesTaken;

    public Student(){

    }

}
