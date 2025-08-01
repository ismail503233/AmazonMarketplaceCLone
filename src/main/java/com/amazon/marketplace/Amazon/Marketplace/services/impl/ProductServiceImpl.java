package com.amazon.marketplace.Amazon.Marketplace.services.impl;

import com.amazon.marketplace.Amazon.Marketplace.dtos.ProductDto;
import com.amazon.marketplace.Amazon.Marketplace.entities.Product;
import com.amazon.marketplace.Amazon.Marketplace.entities.User;
import com.amazon.marketplace.Amazon.Marketplace.mappers.ProductMapper;
import com.amazon.marketplace.Amazon.Marketplace.respositories.ProductRepository;
import com.amazon.marketplace.Amazon.Marketplace.respositories.UserRepository;
import com.amazon.marketplace.Amazon.Marketplace.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final ProductMapper productMapper;
    @Autowired
    private final UserRepository userRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        User user = userRepository.findById(productDto.getSellerId())
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        // Only allow the product creation if the user has a role of "SELLER"
        if (!user.getRole().equals("SELLER")) {
            throw new RuntimeException("User's role is not SELLER");
        }

        Product product = productMapper.mapToProduct(productDto, user);
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToProductDto(savedProduct);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtos = productRepository.findAll()
                .stream().map(productMapper::mapToProductDto).toList();
        return productDtos;
    }

    @Override
    public List<ProductDto> getProductsBySellerId(int sellerId) {
        List<ProductDto> productDtos = productRepository.findBySellerId(sellerId)
                .stream().map(productMapper::mapToProductDto).toList();

        return productDtos;
    }

    @Override
    public ProductDto getProductById(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Product with this ID doesn't exist.") );

        return productMapper.mapToProductDto(product);
    }

    @Override
    public ProductDto updateProductById(int id, ProductDto productDto) {
        Product product = productRepository.findById(id)
                .orElseThrow( ()-> new RuntimeException("Product with this ID doesn't exist.") );

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantityAvailable(productDto.getQuantityAvailable());

        Product savedProduct = productRepository.save(product);
        return productMapper.mapToProductDto(savedProduct);
    }

    @Override
    public String deleteProductById(int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Deleted product with ID " + id;
        }
        return "No such product with ID " + id;
    }
}