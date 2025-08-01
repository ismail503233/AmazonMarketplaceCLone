package com.amazon.marketplace.Amazon.Marketplace.services.impl;


import com.amazon.marketplace.Amazon.Marketplace.dtos.AddressDto;
import com.amazon.marketplace.Amazon.Marketplace.dtos.UserDto;
import com.amazon.marketplace.Amazon.Marketplace.entities.Address;
import com.amazon.marketplace.Amazon.Marketplace.entities.User;
import com.amazon.marketplace.Amazon.Marketplace.mappers.AddressMapper;
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
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        /*
        Step 1: Create a JPA User (entity)
        Step 2: Tell the UserRepository to store the JPA User
        Step 3: Take the JPA User that the DB responds with and
                send that back to the controller.
         */
        User user = userMapper.mapToUser(userDto);
        Address address = addressMapper.mapToAddress(userDto.getAddressDto(), user);
        user.setAddress(address);

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
    public UserDto getUserById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("User with this ID doesn't exist") );

        return userMapper.mapToUserDto(user);
    }

    @Override
    public UserDto updateUserById(UserDto userDto, int id) {
        /*
        1. Retrieve a JPA user by the ID passed
        2. Use setters to update the JPA by using getters on the userDto
        3. Save the updated JPA user back to the database and
        4. Return the response from the DB back to the controller
         */
        User user = userRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("User with this ID doesn't exist") );

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
//        user.setUpdatedAt(userDto.getUpdatedAt());

        if (userDto.getAddressDto() != null) {
            AddressDto addressDto = userDto.getAddressDto();
            Address existingAddress = user.getAddress();

            if (existingAddress == null) {
                Address updatedAddress = addressMapper.mapToAddress(addressDto, user);
                user.setAddress(updatedAddress);
            }
            else {
                existingAddress.setStreet(addressDto.getStreet());
                existingAddress.setCity(addressDto.getCity());
                existingAddress.setState(addressDto.getState());
                existingAddress.setPostalCode(addressDto.getPostalCode());
                existingAddress.setCountry(addressDto.getCountry());
            }
        }

        User savedUser = userRepository.save(user);
        return userMapper.mapToUserDto(savedUser);
    }

    @Override
    public String deleteUserById(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "Deleted user with ID " + id;
        }

        return "No such user with ID " + id;
    }
}
