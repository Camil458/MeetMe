package com.meetme.meetme.controller;

import com.meetme.meetme.model.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RegistrationControllerTest {

    @Autowired
    RegistrationController registrationController;

    @Test
    @Rollback
    @Transactional
    void testSaveNewUser() {}
}
