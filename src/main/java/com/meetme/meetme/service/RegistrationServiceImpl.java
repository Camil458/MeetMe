package com.meetme.meetme.service;

import com.meetme.meetme.entity.User;
import com.meetme.meetme.entity.VerificationToken;
import com.meetme.meetme.exception.EmailNotValidException;
import com.meetme.meetme.exception.TokenExpiredException;
import com.meetme.meetme.exception.TokenNotFoundException;
import com.meetme.meetme.model.UserDTO;
import com.meetme.meetme.security.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final EmailValidator emailValidator;
    private final UserService userService;

    private final VerificationTokenService verificationTokenService;

    @Override
    public void register(UserDTO userDTO) {

        // validate email
        if(!emailValidator.test(userDTO.getEmail())){
            throw new EmailNotValidException(userDTO.getEmail());
        }

        User savedUser = userService.registerNewUserAccount(userDTO);

        // create verification token
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(
                token,
                savedUser
        );
        verificationTokenService.saveVerificationToken(verificationToken);

    }

    public void confirmToken(String token){
        VerificationToken verificationToken = verificationTokenService.getToken(token).orElseThrow(
                TokenNotFoundException::new
        );

        LocalDateTime expiredDate = verificationToken.getExpiryDate();

        if(expiredDate.isBefore(LocalDateTime.now())){
            throw new TokenExpiredException();
        }

        userService.enableUser(verificationToken.getUser().getEmail());
    }
}
