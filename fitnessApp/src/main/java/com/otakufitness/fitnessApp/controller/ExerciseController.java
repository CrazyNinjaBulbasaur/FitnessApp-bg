package com.otakufitness.fitnessApp.controller;


import com.otakufitness.fitnessApp.domain.Fitness.Exercise;
import com.otakufitness.fitnessApp.domain.Fitness.ExerciseDto;
import com.otakufitness.fitnessApp.mapper.ExerciseMapper;
import com.otakufitness.fitnessApp.repository.exceptions.ExerciseNotFoundException;
import com.otakufitness.fitnessApp.service.ExerciseDbService;
import com.otakufitness.fitnessApp.service.facade.ExerciseFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/exercises")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExerciseController {

    private final ExerciseDbService exerciseDbService;
    private final ExerciseMapper exerciseMapper;
    private final ExerciseFacade exerciseFacade;

    @GetMapping
    public ResponseEntity<List<ExerciseDto>> getExercises() {

//        return ResponseEntity.ok(exerciseDbService.getAllExercises().stream()
//                .map(exerciseMapper::mapToExerciseDto)
//                .toList());

        return ResponseEntity.ok(exerciseFacade.getAllExercises());
    }

    @GetMapping(value = "{exerciseId}")
    public ResponseEntity<ExerciseDto> getExercise(@PathVariable long exerciseId) throws ExerciseNotFoundException {
//        return ResponseEntity.ok(exerciseMapper.mapToExerciseDto(exerciseDbService.getExerciseById(exerciseId)));
        return ResponseEntity.ok(exerciseFacade.getExerciseById(exerciseId));
    }

    @PostMapping()
    public ResponseEntity<Void> addExercise(@RequestBody ExerciseDto exerciseDto) {
//        Exercise exercise = exerciseMapper.mapToExercise(exerciseDto);
//        exerciseDbService.saveExercise(exercise);
        exerciseFacade.addExercise(exerciseDto);

        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<ExerciseDto> updateExercise(@RequestBody ExerciseDto exerciseDto) {
//        Exercise exercise= exerciseMapper.mapToExercise(exerciseDto);
//        Exercise savedExercise = exerciseDbService.saveExercise(exercise);
//
//        return ResponseEntity.ok(exerciseMapper.mapToExerciseDto(savedExercise));

        return ResponseEntity.ok(exerciseFacade.updateExercise(exerciseDto));
    }

    @DeleteMapping(value = "{exerciseId}")
    public ResponseEntity<Void> deleteExercise(@PathVariable long exerciseId) {
        exerciseDbService.deleteExerciseById(exerciseId);
        return ResponseEntity.ok().build();
    }


}
