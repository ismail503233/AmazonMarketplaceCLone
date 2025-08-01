package com.amazon.marketplace.Amazon.Marketplace.services;

import com.amazon.marketplace.Amazon.Marketplace.dtos.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserById(int id);
    UserDto updateUserById(UserDto userDto, int id);
    String deleteUserById(int id);
}
