package com.otakufitness.fitnessApp.service.facade;

import com.otakufitness.fitnessApp.domain.nutrition.Ingredient;
import com.otakufitness.fitnessApp.domain.nutrition.IngredientDto;
import com.otakufitness.fitnessApp.mapper.IngredientMapper;
import com.otakufitness.fitnessApp.repository.exceptions.IngredientNotFoundException;
import com.otakufitness.fitnessApp.service.IngredientDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientFacade {

    private final IngredientDbService ingredientDbService;
    private final IngredientMapper ingredientMapper;

    public List<IngredientDto> getAllIngredients(){

        return ingredientDbService.getAllIngredients().stream()
                .map(ingredientMapper::mapToIngredientDto)
                .toList();
    }

    public IngredientDto getIngredientById(long ingredientId) throws IngredientNotFoundException {
        return ingredientMapper.mapToIngredientDto(ingredientDbService.getIngredientById(ingredientId));
    }

    public void addIngredient(IngredientDto ingredientDto){
        Ingredient ingredient = ingredientMapper.mapToIngredient(ingredientDto);
        ingredientDbService.saveIngredient(ingredient);
    }

    public IngredientDto updateIngredient(IngredientDto ingredientDto){
        Ingredient ingredient= ingredientMapper.mapToIngredient(ingredientDto);
        Ingredient savedIngredient = ingredientDbService.saveIngredient(ingredient);

        return ingredientMapper.mapToIngredientDto(savedIngredient);
    }

    public void deleteIngredient(long ingredientId){
        ingredientDbService.deleteIngredientById(ingredientId);
    }
}
