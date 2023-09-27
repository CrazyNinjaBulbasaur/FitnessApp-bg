package com.otakufitness.fitnessApp.domain.Nutrition;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class ProductDto {

    private long id;
    private String name;
    private BigDecimal grams;
    private BigDecimal calories;
    private BigDecimal carbohydrates;
    private BigDecimal fats;
    private BigDecimal protein;
    private List<Ingredient> ingredients;
}
