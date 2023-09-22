package com.otakufitness.fitnessApp.domain.Nutrition;

import com.otakufitness.fitnessApp.domain.Nutrition.product.Product;

public interface NutritionEntry {

    Product calculateNutritionData(double amount, Product product);
}
