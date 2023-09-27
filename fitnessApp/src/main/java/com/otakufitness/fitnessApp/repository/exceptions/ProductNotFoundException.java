package com.otakufitness.fitnessApp.repository.exceptions;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(long id) {
        super("Product with " + id + " not found.");
    }
}
