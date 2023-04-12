package com.meetme.meetme.controller;

import com.meetme.meetme.model.UserDTO;
import com.meetme.meetme.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        registrationService.register(userDTO);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}
