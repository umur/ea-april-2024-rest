package com.ea.studentmanagementapp.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorBody> handleUnknownException(Exception exception) {
        return new ResponseEntity<>(new ErrorBody(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ErrorBody> handleBadRequests(Exception exception) {
        return new ResponseEntity<>(new ErrorBody(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
