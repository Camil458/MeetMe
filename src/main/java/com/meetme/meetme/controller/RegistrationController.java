package com.meetme.meetme.controller;

import com.meetme.meetme.model.UserDTO;
import com.meetme.meetme.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/registration")
public class RegistrationController {

    @Value("${frontend_url}")
    private String FRONTEND_URL;

    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<String> register(@Validated @RequestBody UserDTO userDTO) {
        registrationService.register(userDTO);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }

    @GetMapping(path = "confirm")
    public ResponseEntity<Object> confirm(@RequestParam("token") String token) throws URISyntaxException {
        registrationService.confirmToken(token);

        // redirect to frontend main page
        URI uri = new URI(FRONTEND_URL);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);

        return new ResponseEntity<>(httpHeaders, HttpStatus.valueOf(302));
    }
}
