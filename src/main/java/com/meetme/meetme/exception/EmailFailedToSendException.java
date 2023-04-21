package com.meetme.meetme.exception;

public class EmailFailedToSendException extends RuntimeException{
    public EmailFailedToSendException() {
        super("Failed to send email");
    }
}
