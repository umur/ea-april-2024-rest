package com.ea.studentmanagementapp.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ErrorBody implements Serializable {

    private String message;
}
