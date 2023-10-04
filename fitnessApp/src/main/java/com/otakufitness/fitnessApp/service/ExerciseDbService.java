package com.otakufitness.fitnessApp.service;

import com.otakufitness.fitnessApp.domain.fitness.Exercise;
import com.otakufitness.fitnessApp.repository.ExerciseRepository;
import com.otakufitness.fitnessApp.repository.exceptions.ExerciseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseDbService {

    private final ExerciseRepository repository;

    public List<Exercise> getAllExercises(){
        return repository.findAll();
    }

    public Exercise saveExercise(Exercise exercise){
        return repository.save(exercise);
    }

    public Exercise getExerciseById(Long id) throws ExerciseNotFoundException {
        return repository.findById(id).orElseThrow( () -> new ExerciseNotFoundException(id));
    }

    public void deleteExerciseById(long id){
        repository.deleteById(id);
    }

}
