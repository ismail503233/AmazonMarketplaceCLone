package com.amazon.marketplace.Amazon.Marketplace.mappers;

import com.amazon.marketplace.Amazon.Marketplace.dtos.ProductDto;
import com.amazon.marketplace.Amazon.Marketplace.entities.Product;
import com.amazon.marketplace.Amazon.Marketplace.entities.User;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product mapToProduct(ProductDto productDto, User seller) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantityAvailable(productDto.getQuantityAvailable());
        product.setSeller(seller);
        product.setCategory(productDto.getCategory());

        return product;
    }

    public ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setQuantityAvailable(product.getQuantityAvailable());
        productDto.setSellerId(product.getSeller().getId());
        productDto.setCategory(product.getCategory());
        productDto.setCreatedAt(product.getCreatedAt());
        productDto.setUpdatedAt(product.getUpdatedAt());

        return productDto;
    }
}