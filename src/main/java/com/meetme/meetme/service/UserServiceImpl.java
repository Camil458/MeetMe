package com.meetme.meetme.service;

import com.meetme.meetme.exception.UserAlreadyExistException;
import com.meetme.meetme.mapper.UserMapper;
import com.meetme.meetme.model.Role;
import com.meetme.meetme.model.UserDTO;
import com.meetme.meetme.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDTO registerNewUserAccount(UserDTO userDTO) throws UserAlreadyExistException {

        if(userRepository.findByEmail(userDTO.getEmail()).isPresent()){
            throw new UserAlreadyExistException(userDTO.getEmail());
        }

        userDTO.setRole(Role.USER);
        userDTO.setEnabled(false);
        userDTO.setLocked(false);

        String encodedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);

        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(userDTO)));
    }
}
