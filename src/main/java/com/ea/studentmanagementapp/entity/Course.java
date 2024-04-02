package com.ea.studentmanagementapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Course {

    private Long id;

    private String name;

    private String code;


}
