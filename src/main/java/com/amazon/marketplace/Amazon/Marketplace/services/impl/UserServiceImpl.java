package com.amazon.marketplace.Amazon.Marketplace.services.impl;

import com.amazon.marketplace.Amazon.Marketplace.dtos.UserDto;
import com.amazon.marketplace.Amazon.Marketplace.entities.User;
import com.amazon.marketplace.Amazon.Marketplace.mappers.UserMapper;
import com.amazon.marketplace.Amazon.Marketplace.respositories.UserRepository;
import com.amazon.marketplace.Amazon.Marketplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = userMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.mapToUserDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = userRepository.findAll()
                .stream().map(userMapper::mapToUserDto).toList();

        return userDtos;
    }

    @Override
    public UserDto getUsersById(int id) {
        return null;
    }


    @Override
    public UserDto updateUserById(int id) {
        return null;
    }

    @Override
    public String deleteUsersById(int id) {
        return "";
    }


}
