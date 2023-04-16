package com.meetme.meetme.service;

import com.meetme.meetme.entity.VerificationToken;
import com.meetme.meetme.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VerificationTokenService {
    private final VerificationTokenRepository verificationTokenRepository;

    public void saveVerificationToken(VerificationToken verificationToken){
        verificationTokenRepository.save(verificationToken);
    }

    public Optional<VerificationToken> getToken(String token){
        return verificationTokenRepository.findByToken(token);
    }
}
