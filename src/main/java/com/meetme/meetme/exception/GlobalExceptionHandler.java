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

    @ExceptionHandler(TokenNotFoundException.class)
    public ResponseEntity<ErrorObject> TokenNotFoundException(TokenNotFoundException e) {

        ErrorObject errorObject = ErrorObject.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .timestamp(new Date())
                .build();

        return new ResponseEntity<>(errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<ErrorObject> TokenExpiredException(TokenExpiredException e) {

        ErrorObject errorObject = ErrorObject.builder()
                .statusCode(HttpStatus.GONE.value())
                .message(e.getMessage())
                .timestamp(new Date())
                .build();

        return new ResponseEntity<>(errorObject, HttpStatus.GONE);
    }

    @ExceptionHandler(EmailFailedToSendException.class)
    public ResponseEntity<ErrorObject> TokenExpiredException(EmailFailedToSendException e) {

        ErrorObject errorObject = ErrorObject.builder()
                .statusCode(HttpStatus.GONE.value())
                .message(e.getMessage())
                .timestamp(new Date())
                .build();

        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SerpApiSearchException.class)
    public ResponseEntity<ErrorObject> SerpApiSearchException(SerpApiSearchException e) {

        ErrorObject errorObject = ErrorObject.builder()
                .statusCode(HttpStatus.GONE.value())
                .message(e.getMessage())
                .timestamp(new Date())
                .build();

        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorObject> InvalidCredentialsException(InvalidCredentialsException e) {

        ErrorObject errorObject = ErrorObject.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(e.getMessage())
                .timestamp(new Date())
                .build();

        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }
}
