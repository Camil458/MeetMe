package com.meetme.meetme.service;

import com.meetme.meetme.model.UserDTO;
import com.meetme.meetme.security.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final EmailValidator emailValidator;

    @Override
    public void register(UserDTO userDTO) {
        if(emailValidator.test(userDTO.getEmail())){
            System.out.println("elo");
        }
    }
}
