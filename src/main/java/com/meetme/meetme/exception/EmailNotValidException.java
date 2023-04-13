package com.meetme.meetme.exception;

public class EmailNotValidException extends RuntimeException{
    public EmailNotValidException(String email) {
        super(email + " is not valid email");
    }

    public EmailNotValidException() {
        super("The email address is not valid");
    }
}
