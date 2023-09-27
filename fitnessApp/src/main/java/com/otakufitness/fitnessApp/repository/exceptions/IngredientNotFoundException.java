package com.otakufitness.fitnessApp.repository.exceptions;

public class IngredientNotFoundException extends Exception {

    public IngredientNotFoundException(long id) {
        super("Ingredient with " + id + " not found.");
    }

}
