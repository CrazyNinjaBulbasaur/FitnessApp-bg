package com.otakufitness.fitnessApp.repository.exceptions;

public class FitnessActivityNotFoundException  extends Exception{

    public FitnessActivityNotFoundException(long id) {
        super("FitnessActivity with " + id + " not found.");
    }
}
