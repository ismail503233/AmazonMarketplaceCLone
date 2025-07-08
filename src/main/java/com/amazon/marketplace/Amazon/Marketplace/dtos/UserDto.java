package com.amazon.marketplace.Amazon.Marketplace.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
/*
This is a regular Java object. When the controller
gets JSON objects from a client, it will convert
that JSON into this DTO object.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String role;
    private String profilePictureUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    //    private LocalDateTime createdAt = LocalDateTime.now();
//    private LocalDateTime updatedAt = LocalDateTime.now();
    private AddressDto addressDto;
}
