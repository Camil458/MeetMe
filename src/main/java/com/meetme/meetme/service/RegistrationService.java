package com.meetme.meetme.service;

import com.meetme.meetme.model.UserDTO;

public interface RegistrationService {
    void register(UserDTO userDTO);

    void confirmToken(String token);

}
