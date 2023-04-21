package com.meetme.meetme.exception;

public class TokenExpiredException extends RuntimeException{

    public TokenExpiredException() {
        super("Token expired");
    }
}