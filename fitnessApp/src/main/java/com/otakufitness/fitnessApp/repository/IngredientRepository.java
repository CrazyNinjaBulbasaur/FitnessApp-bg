package com.otakufitness.fitnessApp.repository;

import com.otakufitness.fitnessApp.domain.Nutrition.Ingredient;
import com.otakufitness.fitnessApp.domain.Nutrition.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    @Override
    List<Ingredient> findAll();

    @Override
    Ingredient save(Ingredient ingredient);

    @Override
    Optional<Ingredient> findById(Long id);

    @Override
    void deleteById(Long id);
}
