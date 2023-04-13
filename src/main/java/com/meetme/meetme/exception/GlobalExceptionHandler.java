package com.meetme.meetme.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailNotValidException.class)
    public ResponseEntity<ErrorObject> EmailNotValidException(EmailNotValidException e) {

        ErrorObject errorObject = ErrorObject.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(e.getMessage())
                .timestamp(new Date())
                .build();

        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ErrorObject> UserAlreadyExistException(UserAlreadyExistException e) {

        ErrorObject errorObject = ErrorObject.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(e.getMessage())
                .timestamp(new Date())
                .build();

        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }
}
