package com.otakufitness.fitnessApp.domain.nutrition;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
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
