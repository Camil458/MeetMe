package com.meetme.meetme.controller;

import com.meetme.meetme.model.LoginDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/login")
public class LoginController {

    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity login(@RequestBody LoginDto loginDto) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (BadCredentialsException e){
            throw new IndexOutOfBoundsException();
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/logged")
    public Boolean isLogged(){
        try {
            //return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails;
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
