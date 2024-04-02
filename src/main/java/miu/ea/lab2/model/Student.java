package miu.ea.lab2.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;

@Schema(
        description = "Student Model Information"
)
@Data
public class Student {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;

    private List<Course> coursesTaken;
}
