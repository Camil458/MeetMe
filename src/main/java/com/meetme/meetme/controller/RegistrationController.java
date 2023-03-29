package com.meetme.meetme.controller;

import com.meetme.meetme.model.UserDTO;
import com.meetme.meetme.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity signup(@RequestBody UserDTO userDTO){
        UserDTO savedUser = userService.saveNewUser(userDTO);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
