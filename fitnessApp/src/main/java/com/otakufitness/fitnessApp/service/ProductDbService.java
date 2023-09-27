package com.otakufitness.fitnessApp.service;

import com.otakufitness.fitnessApp.domain.Nutrition.Product;
import com.otakufitness.fitnessApp.repository.ProductRepository;
import com.otakufitness.fitnessApp.repository.exceptions.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDbService {

    @Autowired
    private final ProductRepository repository;

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public Product getProductById(Long id) throws ProductNotFoundException {
        return repository.findById(id).orElseThrow( () -> new ProductNotFoundException(id));
    }

    public void deleteProductById(long id) {
        repository.deleteById(id);
    }
}
