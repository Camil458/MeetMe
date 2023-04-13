package com.meetme.meetme.service;

import com.meetme.meetme.exception.EmailNotValidException;
import com.meetme.meetme.model.UserDTO;
import com.meetme.meetme.security.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final EmailValidator emailValidator;
    private final UserService userService;

    @Override
    public void register(UserDTO userDTO) {

        // validate email
        if(!emailValidator.test(userDTO.getEmail())){
            throw new EmailNotValidException(userDTO.getEmail());
        }

        UserDTO savedUser = userService.registerNewUserAccount(userDTO);
    }
}
