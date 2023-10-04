package com.otakufitness.fitnessApp.repository;

import com.otakufitness.fitnessApp.domain.nutrition.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    @Override
    List<Ingredient> findAll();

}
