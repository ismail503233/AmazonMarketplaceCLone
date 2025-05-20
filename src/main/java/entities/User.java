package com.amazon.marketplace.ata.AmazonMarketplace.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/*
This is the JPA object. This is what we send to the DB.
Also, when we retrieve User objects from the DB, they
will be in the form of JPA objects.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name="last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name="email", nullable = false, unique = true, length = 100)
    private String email;
    @Column(name="username", nullable = false, unique = true, length = 30)
    private String username;
    @Column(name="password", nullable = false, length = 255)
    private String password;
    @Column(name="role", nullable = false, length = 30)
    private String role;
    @Column(name="profile_picture_url", nullable = false, length = 500)
    private String profilePictureUrl;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
}
