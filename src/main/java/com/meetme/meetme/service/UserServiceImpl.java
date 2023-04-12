package com.meetme.meetme.service;

import com.meetme.meetme.mapper.UserMapper;
import com.meetme.meetme.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final static String USERNAME_NOT_FOUND_MSG = "%s not found";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.userToUserDto(userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USERNAME_NOT_FOUND_MSG, username))));
    }
}
