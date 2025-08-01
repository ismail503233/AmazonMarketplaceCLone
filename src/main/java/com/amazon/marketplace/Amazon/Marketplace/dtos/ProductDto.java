package com.amazon.marketplace.Amazon.Marketplace.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantityAvailable;
    private int sellerId;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
