package com.otakufitness.fitnessApp.repository;

import com.otakufitness.fitnessApp.domain.nutrition.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    List<Product> findAll();

    List<Product> findByName(String name);

}
