package com.otakufitness.fitnessApp.mapper;

import com.otakufitness.fitnessApp.domain.fitness.FitnessActivity;
import com.otakufitness.fitnessApp.domain.fitness.FitnessActivityDto;
import org.springframework.stereotype.Component;

@Component
public class FitnessActivityMapper {

    public FitnessActivity mapToFitnessActivity(final FitnessActivityDto fitnessActivityDto){
        return new FitnessActivity(fitnessActivityDto.getId(),
                fitnessActivityDto.getDuration(),
                fitnessActivityDto.getExercise(),
                fitnessActivityDto.getDailyJournals()
        );
    }

    public FitnessActivityDto mapToFitnessActivityDto(final FitnessActivity fitnessActivity){
        return new FitnessActivityDto(fitnessActivity.getId(),
                fitnessActivity.getDuration(),
                fitnessActivity.getExercise(),
                fitnessActivity.getDailyJournals()
        );
    }
}
