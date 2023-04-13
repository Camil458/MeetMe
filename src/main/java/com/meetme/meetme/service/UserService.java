package com.meetme.meetme.service;

import com.meetme.meetme.model.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    public UserDTO registerNewUserAccount(UserDTO userDTO);
}

/*
public interface UserService extends UserDetailsService {
    public UserDTO registerNewUserAccount(UserDTO userDTO);
}
 */