package com.meetme.meetme.exception;

public class TokenNotFoundException extends RuntimeException{

    public TokenNotFoundException() {
        super("Token not found");
    }
}