package com.otakufitness.fitnessApp.service;

import com.otakufitness.fitnessApp.domain.Nutrition.Ingredient;
import com.otakufitness.fitnessApp.repository.IngredientRepository;
import com.otakufitness.fitnessApp.repository.exceptions.IngredientNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientDbService {

    private final IngredientRepository repository;

    public List<Ingredient> getAllIngredients(){
        return repository.findAll();
    }

    public Ingredient saveIngredient(Ingredient ingredient){
        return repository.save(ingredient);
    }

    public Ingredient getIngredientById(Long id) throws IngredientNotFoundException {
        return repository.findById(id).orElseThrow( () -> new IngredientNotFoundException(id));
    }

    public void deleteIngredientById(long id){
        repository.deleteById(id);
    }
}
