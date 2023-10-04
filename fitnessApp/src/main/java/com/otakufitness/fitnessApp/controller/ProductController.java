package com.otakufitness.fitnessApp.controller;

import com.otakufitness.fitnessApp.domain.nutrition.Product;
import com.otakufitness.fitnessApp.domain.nutrition.ProductDto;
import com.otakufitness.fitnessApp.mapper.ProductMapper;
import com.otakufitness.fitnessApp.repository.exceptions.ProductNotFoundException;
import com.otakufitness.fitnessApp.service.ProductDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductDbService productDbService;
    private final ProductMapper productMapper;


    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {

        return ResponseEntity.ok(productDbService.getAllProducts().stream()
                .map(productMapper::mapToProductDto)
                .toList());
    }

    @GetMapping(value = "{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable long productId) throws ProductNotFoundException {
        return ResponseEntity.ok(productMapper.mapToProductDto(productDbService.getProductById(productId)));
    }

    @PostMapping()
    public ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        productDbService.saveProduct(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        Product product= productMapper.mapToProduct(productDto);
        Product savedProduct = productDbService.saveProduct(product);

        return ResponseEntity.ok(productMapper.mapToProductDto(savedProduct));
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long productId) {
        productDbService.deleteProductById(productId);
        return ResponseEntity.ok().build();
    }

}
