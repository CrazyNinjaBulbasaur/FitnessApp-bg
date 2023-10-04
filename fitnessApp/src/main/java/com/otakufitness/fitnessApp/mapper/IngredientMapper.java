package com.otakufitness.fitnessApp.mapper;

import com.otakufitness.fitnessApp.domain.nutrition.Ingredient;
import com.otakufitness.fitnessApp.domain.nutrition.IngredientDto;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    public Ingredient mapToIngredient(final IngredientDto ingredientDto){
        return new Ingredient(ingredientDto.getId(),
                ingredientDto.getGrams(),
                ingredientDto.getProduct(),
                ingredientDto.getDailyJournals()
        );
    }

    public IngredientDto mapToIngredientDto(final Ingredient ingredient){
        return new IngredientDto(ingredient.getId(),
                ingredient.getGrams(),
                ingredient.getProduct(),
                ingredient.getDailyJournals()
        );
    }
}
