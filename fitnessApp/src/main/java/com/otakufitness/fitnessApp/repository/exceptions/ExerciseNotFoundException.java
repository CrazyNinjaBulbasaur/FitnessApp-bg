package com.otakufitness.fitnessApp.repository.exceptions;

public class ExerciseNotFoundException extends Exception{

    public ExerciseNotFoundException(long id) {
        super("Exercise with " + id + " not found.");
    }
}
