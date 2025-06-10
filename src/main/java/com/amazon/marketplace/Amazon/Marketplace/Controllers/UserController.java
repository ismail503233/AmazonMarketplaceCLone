package com.amazon.marketplace.Amazon.Marketplace.Controllers;

import com.amazon.marketplace.Amazon.Marketplace.dtos.UserDto;
import com.amazon.marketplace.Amazon.Marketplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers90(){
        List<UserDto> usersDtos = userService.getAllUsers();
        return ResponseEntity.ok(usersDtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(int id) {
        UserDto userDto = userService.getUsersById(id);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable int id, @RequestBody UserDto userDto ){
        UserDto updatedUserDto = userService.updateUserById(userDto, id);
        return ResponseEntity.ok(updatedUserDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsersById(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUsersById(id));
    }
}
