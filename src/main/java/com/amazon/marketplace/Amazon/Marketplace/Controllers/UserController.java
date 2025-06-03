package com.amazon.marketplace.Amazon.Marketplace.Controllers;

import com.amazon.marketplace.Amazon.Marketplace.dtos.UserDto;
import com.amazon.marketplace.Amazon.Marketplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    public ResponseEntity<List<UserDto>> getAllUsers90(){
        List<UserDto> usersDtos = userService.getAllUsers();
        return ResponseEntity.ok(usersDtos);
    }
}
