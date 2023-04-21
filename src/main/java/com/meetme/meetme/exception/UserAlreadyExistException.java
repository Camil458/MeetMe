package com.meetme.meetme.exception;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String email) {
        super("There is an account with that email address: " + email);
    }

    public UserAlreadyExistException() {
        super("There is an account with that email address");
    }
}
