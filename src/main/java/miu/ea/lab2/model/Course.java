package miu.ea.lab2.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(
    description = "Course Model Information"
)
@Data
public class Course {
    private long id;
    private String name;
    private String code;
}
