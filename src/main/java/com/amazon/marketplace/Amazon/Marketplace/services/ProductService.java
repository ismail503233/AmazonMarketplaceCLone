package com.amazon.marketplace.Amazon.Marketplace.services;

import com.amazon.marketplace.Amazon.Marketplace.dtos.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct (ProductDto productDto);
    List<ProductDto> getAllProducts();
    List<ProductDto> getProductsBySellerId(int sellerId);
    ProductDto getProductById(int id);
    ProductDto updateProductById(int id, ProductDto productDto);
    String deleteProductById(int id);

}
