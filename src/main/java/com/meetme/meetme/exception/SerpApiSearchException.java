package com.meetme.meetme.exception;

public class SerpApiSearchException extends Exception {
    public SerpApiSearchException() {
        super();
    }

    public SerpApiSearchException(Exception exception) {
        super(exception);
    }

    public SerpApiSearchException(String message) {
        super(message);
    }
}
