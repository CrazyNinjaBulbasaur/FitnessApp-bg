package com.otakufitness.fitnessApp.controller;

import com.otakufitness.fitnessApp.domain.fitness.ExerciseDto;
import com.otakufitness.fitnessApp.repository.exceptions.ExerciseNotFoundException;
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

    private final ExerciseFacade exerciseFacade;

    @GetMapping
    public ResponseEntity<List<ExerciseDto>> getExercises() {
        return ResponseEntity.ok(exerciseFacade.getAllExercises());
    }

    @GetMapping(value = "{exerciseId}")
    public ResponseEntity<ExerciseDto> getExercise(@PathVariable long exerciseId) throws ExerciseNotFoundException {
        return ResponseEntity.ok(exerciseFacade.getExerciseById(exerciseId));
    }

    @PostMapping()
    public ResponseEntity<Void> addExercise(@RequestBody ExerciseDto exerciseDto) {
        exerciseFacade.addExercise(exerciseDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<ExerciseDto> updateExercise(@RequestBody ExerciseDto exerciseDto) {
        return ResponseEntity.ok(exerciseFacade.updateExercise(exerciseDto));
    }

    @DeleteMapping(value = "{exerciseId}")
    public ResponseEntity<Void> deleteExercise(@PathVariable long exerciseId) {
        exerciseFacade.deleteExercise(exerciseId);
        return ResponseEntity.ok().build();
    }
}
