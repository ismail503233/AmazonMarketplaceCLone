package com.amazon.marketplace.Amazon.Marketplace.respositories;

import com.amazon.marketplace.Amazon.Marketplace.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findBySellerId(int sellerId);
}