package com.amazon.marketplace.Amazon.Marketplace.Controllers;

import com.amazon.marketplace.Amazon.Marketplace.dtos.ProductDto;
import com.amazon.marketplace.Amazon.Marketplace.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable int id) {
        ProductDto productDto = productService.getProductById(id);
        return ResponseEntity.ok(productDto);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtos = productService.getAllProducts();
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<List<ProductDto>> getProductsBySellerId(@PathVariable int sellerId) {
        List<ProductDto> productDtos = productService.getProductsBySellerId(sellerId);
        return ResponseEntity.ok(productDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProductById(@PathVariable int id, @RequestBody ProductDto productDto) {
        ProductDto updatedProductDto = productService.updateProductById(id, productDto);
        return ResponseEntity.ok(updatedProductDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable int id) {
        return ResponseEntity.ok(productService.deleteProductById(id));
    }
}