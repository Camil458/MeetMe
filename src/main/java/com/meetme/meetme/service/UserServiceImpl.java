package com.meetme.meetme.service;

import com.meetme.meetme.mapper.UserMapper;
import com.meetme.meetme.model.UserDTO;
import com.meetme.meetme.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO saveNewUser(UserDTO userDTO) {
        return userMapper.userToUserDto(userRepository
                .save(userMapper.userDtoToUser(userDTO)));
    }
}
