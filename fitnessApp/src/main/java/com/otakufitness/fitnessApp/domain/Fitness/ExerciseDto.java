package com.otakufitness.fitnessApp.domain.Fitness;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ExerciseDto {
    private long id;
    private String name;
    private String description;

    private int caloriesBurnedInOneHour;

    private List<FitnessActivity> fitnessActivities;
}
