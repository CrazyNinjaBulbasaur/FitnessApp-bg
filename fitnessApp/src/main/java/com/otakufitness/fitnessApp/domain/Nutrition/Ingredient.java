package com.otakufitness.fitnessApp.domain.Nutrition;

import com.otakufitness.fitnessApp.domain.Nutrition.product.Product;

public class Ingredient implements NutritionEntry{

    double amount;

    Product product;

    @Override
    public Product calculateNutritionData(double amount, Product product) {
        return null;
    }
}
