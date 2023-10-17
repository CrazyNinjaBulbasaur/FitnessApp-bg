package com.otakufitness.fitnessApp.service.facade;

import com.otakufitness.fitnessApp.domain.fitness.Exercise;
import com.otakufitness.fitnessApp.domain.fitness.ExerciseDto;
import com.otakufitness.fitnessApp.mapper.ExerciseMapper;
import com.otakufitness.fitnessApp.repository.exceptions.ExerciseNotFoundException;
import com.otakufitness.fitnessApp.service.ExerciseDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseFacade {

    private final ExerciseDbService exerciseDbService;
    private final ExerciseMapper exerciseMapper;

    public List<ExerciseDto> getAllExercises(){

        return exerciseDbService.getAllExercises().stream()
                .map(exerciseMapper::mapToExerciseDto)
                .toList();
    }

    public ExerciseDto getExerciseById(long exerciseId) throws ExerciseNotFoundException {
        return exerciseMapper.mapToExerciseDto(exerciseDbService.getExerciseById(exerciseId));
    }

    public void addExercise(ExerciseDto exerciseDto){
        Exercise exercise = exerciseMapper.mapToExercise(exerciseDto);
        exerciseDbService.saveExercise(exercise);
    }

    public ExerciseDto updateExercise(ExerciseDto exerciseDto){
        Exercise exercise= exerciseMapper.mapToExercise(exerciseDto);
        Exercise savedExercise = exerciseDbService.saveExercise(exercise);

        return exerciseMapper.mapToExerciseDto(savedExercise);
    }

    public void deleteExercise(long exerciseId){
        exerciseDbService.deleteExerciseById(exerciseId);
    }
}
