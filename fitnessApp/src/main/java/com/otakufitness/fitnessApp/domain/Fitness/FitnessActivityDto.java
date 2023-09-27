package com.otakufitness.fitnessApp.domain.Fitness;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FitnessActivityDto {
    private long id;
    private String duration;
    private Exercise exercise;
}
