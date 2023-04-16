package com.meetme.meetme.controller;

import com.meetme.meetme.model.UserDTO;
import com.meetme.meetme.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<String> register(@Validated @RequestBody UserDTO userDTO) {
        registrationService.register(userDTO);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }

    @GetMapping(path = "confirm")
    public ResponseEntity<String> confirm(@RequestParam("token") String token){
        registrationService.confirmToken(token);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
