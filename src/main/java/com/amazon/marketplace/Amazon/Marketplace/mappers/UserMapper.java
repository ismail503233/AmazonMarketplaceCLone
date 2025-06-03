package com.amazon.marketplace.Amazon.Marketplace.mappers;

import com.amazon.marketplace.Amazon.Marketplace.entities.User;
import com.amazon.marketplace.Amazon.Marketplace.dtos.UserDto;
import org.springframework.stereotype.Component;

/*
The purpose of this class is to take a DTO object and conver it
into a JPA object. And to take a JPA object and convert it into
a DTO object.
 */

@Component
public class UserMapper {
    public User mapToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setProfilePictureUrl(userDto.getProfilePictureUrl());

        return user;
    }

    public UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        userDto.setProfilePictureUrl(user.getProfilePictureUrl());
        return userDto;
    }
}