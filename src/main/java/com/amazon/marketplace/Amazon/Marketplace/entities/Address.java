package com.amazon.marketplace.Amazon.Marketplace.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
@Entity
public class Address {
    @Id
    private int id;
    @Column(name="user_id")
    private int userId;
    @Column(name= "street", nullable = false)
    private String street;
    @Column(name="city", nullable = false, length = 100)
    private String city;
    @Column(name="state", nullable = false, length = 100)
    private String state;
    @Column(name="postal_code", nullable = false, length = 10)
    private String postalCode;
    @Column(name="country", nullable = false, length=100)
    private String country;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

}
