package com.otakufitness.fitnessApp.service.facade;


import com.otakufitness.fitnessApp.domain.nutrition.Product;
import com.otakufitness.fitnessApp.domain.nutrition.ProductDto;
import com.otakufitness.fitnessApp.mapper.ProductMapper;
import com.otakufitness.fitnessApp.repository.exceptions.ProductNotFoundException;
import com.otakufitness.fitnessApp.service.ProductDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductFacade {

    private final ProductDbService productDbService;
    private final ProductMapper productMapper;

    public List<ProductDto> getAllProducts(){

        return productDbService.getAllProducts().stream()
                .map(productMapper::mapToProductDto)
                .toList();
    }

    public ProductDto getProductById(long productId) throws ProductNotFoundException {
        return productMapper.mapToProductDto(productDbService.getProductById(productId));
    }

    public void addProduct(ProductDto productDto){
        Product product = productMapper.mapToProduct(productDto);
        productDbService.saveProduct(product);
    }

    public ProductDto updateProduct(ProductDto productDto){
        Product product= productMapper.mapToProduct(productDto);
        Product savedProduct = productDbService.saveProduct(product);

        return productMapper.mapToProductDto(savedProduct);
    }

    public void deleteProduct(long productId){
        productDbService.deleteProductById(productId);
    }
}
