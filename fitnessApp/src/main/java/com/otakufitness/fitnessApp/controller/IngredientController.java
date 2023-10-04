package com.otakufitness.fitnessApp.controller;

import com.otakufitness.fitnessApp.domain.nutrition.Ingredient;
import com.otakufitness.fitnessApp.domain.nutrition.IngredientDto;
import com.otakufitness.fitnessApp.mapper.IngredientMapper;
import com.otakufitness.fitnessApp.repository.exceptions.IngredientNotFoundException;
import com.otakufitness.fitnessApp.service.IngredientDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ingredients")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IngredientController {

    private final IngredientDbService ingredientDbService;
    private final IngredientMapper ingredientMapper;

    @GetMapping
    public ResponseEntity<List<IngredientDto>> getIngredients() {

        return ResponseEntity.ok(ingredientDbService.getAllIngredients().stream()
                .map(ingredientMapper::mapToIngredientDto)
                .toList());
    }

    @GetMapping(value = "{ingredientId}")
    public ResponseEntity<IngredientDto> getIngredient(@PathVariable long ingredientId) throws IngredientNotFoundException {
        return ResponseEntity.ok(ingredientMapper.mapToIngredientDto(ingredientDbService.getIngredientById(ingredientId)));
    }

    @PostMapping()
    public ResponseEntity<Void> addIngredient(@RequestBody IngredientDto ingredientDto) {
        Ingredient ingredient = ingredientMapper.mapToIngredient(ingredientDto);
        ingredientDbService.saveIngredient(ingredient);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<IngredientDto> updateIngredient(@RequestBody IngredientDto ingredientDto) {
        Ingredient ingredient= ingredientMapper.mapToIngredient(ingredientDto);
        Ingredient savedIngredient = ingredientDbService.saveIngredient(ingredient);

        return ResponseEntity.ok(ingredientMapper.mapToIngredientDto(savedIngredient));
    }

    @DeleteMapping(value = "{ingredientId}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable long ingredientId) {
        ingredientDbService.deleteIngredientById(ingredientId);
        return ResponseEntity.ok().build();
    }
}
