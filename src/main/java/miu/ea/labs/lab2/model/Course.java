package miu.ea.labs.lab2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Course {
    private Long id;
    private String name;
    private String code;
}
