package com.otakufitness.fitnessApp.controller;


import com.otakufitness.fitnessApp.domain.Fitness.FitnessActivity;
import com.otakufitness.fitnessApp.domain.Fitness.FitnessActivityDto;
import com.otakufitness.fitnessApp.mapper.FitnessActivityMapper;
import com.otakufitness.fitnessApp.repository.exceptions.FitnessActivityNotFoundException;
import com.otakufitness.fitnessApp.service.FitnessActivityDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/fitnessActivities")
@RequiredArgsConstructor
@CrossOrigin("*")
public class FitnessActivityController {
    private final FitnessActivityDbService fitnessActivityDbService;
    private final FitnessActivityMapper fitnessActivityMapper;

    @GetMapping
    public ResponseEntity<List<FitnessActivityDto>> getFitnessActivities() {

        return ResponseEntity.ok(fitnessActivityDbService.getAllFitnessActivities().stream()
                .map(fitnessActivityMapper::mapToFitnessActivityDto)
                .toList());
    }

    @GetMapping(value = "{fitnessActivityId}")
    public ResponseEntity<FitnessActivityDto> getFitnessActivity(@PathVariable long fitnessActivityId) throws FitnessActivityNotFoundException {
        return ResponseEntity.ok(fitnessActivityMapper.mapToFitnessActivityDto(fitnessActivityDbService.getFitnessActivityById(fitnessActivityId)));
    }

    @PostMapping()
    public ResponseEntity<Void> addFitnessActivity(@RequestBody FitnessActivityDto fitnessActivityDto) {
        FitnessActivity fitnessActivity = fitnessActivityMapper.mapToFitnessActivity(fitnessActivityDto);
        fitnessActivityDbService.saveFitnessActivity(fitnessActivity);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<FitnessActivityDto> updateFitnessActivity(@RequestBody FitnessActivityDto fitnessActivityDto) {
        FitnessActivity fitnessActivity = fitnessActivityMapper.mapToFitnessActivity(fitnessActivityDto);
        FitnessActivity savedFitnessActivity = fitnessActivityDbService.saveFitnessActivity(fitnessActivity);

        return ResponseEntity.ok(fitnessActivityMapper.mapToFitnessActivityDto(savedFitnessActivity));
    }

    @DeleteMapping(value = "{fitnessActivityId}")
    public ResponseEntity<Void> deleteFitnessActivity(@PathVariable long fitnessActivityId) {
        fitnessActivityDbService.deleteFitnessActivityById(fitnessActivityId);
        return ResponseEntity.ok().build();
    }

}
