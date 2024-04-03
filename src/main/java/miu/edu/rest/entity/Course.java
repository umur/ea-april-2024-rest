package miu.edu.rest.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Course {

    private Long courseId;
    private String name;
    private String code;
    private List<Student> students;

}
