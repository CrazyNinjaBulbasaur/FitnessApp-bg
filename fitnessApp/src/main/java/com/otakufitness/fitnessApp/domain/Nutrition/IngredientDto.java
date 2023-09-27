package com.otakufitness.fitnessApp.domain.Nutrition;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class IngredientDto {
    private long id;
    private BigDecimal grams;
    private Product product;
}
