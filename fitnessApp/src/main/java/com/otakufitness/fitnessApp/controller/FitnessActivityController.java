package com.otakufitness.fitnessApp.controller;


import com.otakufitness.fitnessApp.domain.fitness.FitnessActivityDto;
import com.otakufitness.fitnessApp.repository.exceptions.FitnessActivityNotFoundException;
import com.otakufitness.fitnessApp.service.facade.FitnessActivityFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/fitnessActivities")
@RequiredArgsConstructor
@CrossOrigin("*")
public class FitnessActivityController {

    private final FitnessActivityFacade fitnessActivityFacade;

    @GetMapping
    public ResponseEntity<List<FitnessActivityDto>> getFitnessActivities() {
        return ResponseEntity.ok(fitnessActivityFacade.getAllFitnessActivities());
    }

    @GetMapping(value = "{fitnessActivityId}")
    public ResponseEntity<FitnessActivityDto> getFitnessActivity(@PathVariable long fitnessActivityId) throws FitnessActivityNotFoundException {
        return ResponseEntity.ok(fitnessActivityFacade.getFitnessActivityById(fitnessActivityId));
    }

    @PostMapping()
    public ResponseEntity<Void> addFitnessActivity(@RequestBody FitnessActivityDto fitnessActivityDto) {
        fitnessActivityFacade.addFitnessActivity(fitnessActivityDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<FitnessActivityDto> updateFitnessActivity(@RequestBody FitnessActivityDto fitnessActivityDto) {
        return ResponseEntity.ok(fitnessActivityFacade.updateFitnessActivity(fitnessActivityDto));
    }

    @DeleteMapping(value = "{fitnessActivityId}")
    public ResponseEntity<Void> deleteFitnessActivity(@PathVariable long fitnessActivityId) {
        fitnessActivityFacade.deleteFitnessActivity(fitnessActivityId);
        return ResponseEntity.ok().build();
    }

}
