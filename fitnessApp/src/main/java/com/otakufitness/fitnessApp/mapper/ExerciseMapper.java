package com.otakufitness.fitnessApp.mapper;

import com.otakufitness.fitnessApp.domain.Fitness.Exercise;
import com.otakufitness.fitnessApp.domain.Fitness.ExerciseDto;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper {

    public Exercise mapToExercise(final ExerciseDto exerciseDto){
        return new Exercise(exerciseDto.getId(),
                exerciseDto.getName(),
                exerciseDto.getDescription(),
                exerciseDto.getCaloriesBurnedInSixtySeconds(),
                exerciseDto.getFitnessActivities()
        );
    }

    public ExerciseDto mapToExerciseDto(final Exercise exercise){
        return new ExerciseDto(exercise.getId(),
                exercise.getName(),
                exercise.getDescription(),
                exercise.getCaloriesBurnedInSixtyMinutes(),
                exercise.getFitnessActivities()
        );
    }
}
