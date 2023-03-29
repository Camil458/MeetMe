package com.meetme.meetme.mapper;

import com.meetme.meetme.entity.User;
import com.meetme.meetme.model.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User userDtoToUser(UserDTO userDTO);
    UserDTO userToUserDto(User user);
}
