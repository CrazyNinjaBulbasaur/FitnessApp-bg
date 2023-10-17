package com.otakufitness.fitnessApp.controller;

import com.otakufitness.fitnessApp.domain.nutrition.ProductDto;
import com.otakufitness.fitnessApp.repository.exceptions.ProductNotFoundException;
import com.otakufitness.fitnessApp.service.facade.ProductFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductFacade productFacade;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(productFacade.getAllProducts());
    }

    @GetMapping(value = "{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable long productId) throws ProductNotFoundException {
        return ResponseEntity.ok(productFacade.getProductById(productId));
    }

    @PostMapping()
    public ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto) {
        productFacade.addProduct(productDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productFacade.updateProduct(productDto));
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long productId) {
        productFacade.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

}
