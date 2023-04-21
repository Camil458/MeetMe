package com.meetme.meetme.email;

public interface EmailSender {
    void send(String email, String name, String link);
}
