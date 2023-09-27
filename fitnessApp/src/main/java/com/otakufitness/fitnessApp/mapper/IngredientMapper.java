package com.otakufitness.fitnessApp.mapper;

import com.otakufitness.fitnessApp.domain.Nutrition.Ingredient;
import com.otakufitness.fitnessApp.domain.Nutrition.IngredientDto;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    public Ingredient mapToIngredient(final IngredientDto ingredientDto){
        return new Ingredient(ingredientDto.getId(),
                ingredientDto.getGrams(),
                ingredientDto.getProduct());
    }

    public IngredientDto mapToIngredientDto(final Ingredient ingredient){
        return new IngredientDto(ingredient.getId(),
                ingredient.getGrams(),
                ingredient.getProduct());
    }
}
