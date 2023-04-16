package com.meetme.meetme.service;

import com.meetme.meetme.entity.User;
import com.meetme.meetme.model.UserDTO;

public interface UserService {
    public User registerNewUserAccount(UserDTO userDTO);

    void enableUser(String email);
}
