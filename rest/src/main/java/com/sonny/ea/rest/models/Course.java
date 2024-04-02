package com.sonny.ea.rest.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Course {
    private final Long id;
    private String name;
    private String code;
}
