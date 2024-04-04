package com.example.course.Domain;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {

    private long id;
    private String name;
    private int code;

    public Course(long id, String name, int code) {
        this.id = id;
        this.name = name;
        this.code = code;

    }

    public Course() {

    }
}
