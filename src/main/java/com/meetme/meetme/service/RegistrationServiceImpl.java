package com.meetme.meetme.service;

import com.meetme.meetme.email.EmailSender;
import com.meetme.meetme.entity.User;
import com.meetme.meetme.entity.VerificationToken;
import com.meetme.meetme.exception.EmailNotValidException;
import com.meetme.meetme.exception.TokenExpiredException;
import com.meetme.meetme.exception.TokenNotFoundException;
import com.meetme.meetme.model.UserDTO;
import com.meetme.meetme.security.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    @Value("${backend_url}")
    private String BACKEND_URL;
    private final EmailValidator emailValidator;
    private final UserService userService;
    private final VerificationTokenService verificationTokenService;
    private final EmailSender emailSender;


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

        // send email
        String link = BACKEND_URL + "registration/confirm?token=" + token;
        emailSender.send(savedUser.getEmail(), savedUser.getFirstName(), link);
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
