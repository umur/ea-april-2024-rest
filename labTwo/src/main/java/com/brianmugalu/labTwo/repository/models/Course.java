package com.brianmugalu.labTwo.repository.models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Course {
    private Long id;
    private String name;
    private String code;

}
