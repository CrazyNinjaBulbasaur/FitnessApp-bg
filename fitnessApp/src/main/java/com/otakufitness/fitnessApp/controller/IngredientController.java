package com.otakufitness.fitnessApp.controller;

import com.otakufitness.fitnessApp.domain.nutrition.IngredientDto;
import com.otakufitness.fitnessApp.repository.exceptions.IngredientNotFoundException;
import com.otakufitness.fitnessApp.service.facade.IngredientFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ingredients")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IngredientController {

    private final IngredientFacade ingredientFacade;

    @GetMapping
    public ResponseEntity<List<IngredientDto>> getIngredients() {
        return ResponseEntity.ok(ingredientFacade.getAllIngredients());
    }

    @GetMapping(value = "{ingredientId}")
    public ResponseEntity<IngredientDto> getIngredient(@PathVariable long ingredientId) throws IngredientNotFoundException {
        return ResponseEntity.ok(ingredientFacade.getIngredientById(ingredientId));
    }

    @PostMapping()
    public ResponseEntity<Void> addIngredient(@RequestBody IngredientDto ingredientDto) {
        ingredientFacade.addIngredient(ingredientDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<IngredientDto> updateIngredient(@RequestBody IngredientDto ingredientDto) {
        return ResponseEntity.ok(ingredientFacade.updateIngredient(ingredientDto));
    }

    @DeleteMapping(value = "{ingredientId}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable long ingredientId) {
        ingredientFacade.deleteIngredient(ingredientId);
        return ResponseEntity.ok().build();
    }
}
