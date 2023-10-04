package com.otakufitness.fitnessApp.domain.fitness;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ExerciseDto {
    private long id;
    private String name;
    private String description;
    private int caloriesBurnedInSixtySeconds;
    private List<FitnessActivity> fitnessActivities;
}
