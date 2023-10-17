package com.otakufitness.fitnessApp.service.facade;

import com.otakufitness.fitnessApp.domain.fitness.FitnessActivity;
import com.otakufitness.fitnessApp.domain.fitness.FitnessActivityDto;
import com.otakufitness.fitnessApp.mapper.FitnessActivityMapper;
import com.otakufitness.fitnessApp.repository.exceptions.FitnessActivityNotFoundException;
import com.otakufitness.fitnessApp.service.FitnessActivityDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FitnessActivityFacade {

    private final FitnessActivityDbService fitnessActivityDbService;
    private final FitnessActivityMapper fitnessActivityMapper;

    public List<FitnessActivityDto> getAllFitnessActivities(){

        return fitnessActivityDbService.getAllFitnessActivities().stream()
                .map(fitnessActivityMapper::mapToFitnessActivityDto)
                .toList();
    }

    public FitnessActivityDto getFitnessActivityById(long fitnessActivityId) throws FitnessActivityNotFoundException {
        return fitnessActivityMapper.mapToFitnessActivityDto(fitnessActivityDbService.getFitnessActivityById(fitnessActivityId));
    }

    public void addFitnessActivity(FitnessActivityDto fitnessActivityDto){
        FitnessActivity fitnessActivity = fitnessActivityMapper.mapToFitnessActivity(fitnessActivityDto);
        fitnessActivityDbService.saveFitnessActivity(fitnessActivity);
    }

    public FitnessActivityDto updateFitnessActivity(FitnessActivityDto fitnessActivityDto){
        FitnessActivity fitnessActivity= fitnessActivityMapper.mapToFitnessActivity(fitnessActivityDto);
        FitnessActivity savedFitnessActivity = fitnessActivityDbService.saveFitnessActivity(fitnessActivity);

        return fitnessActivityMapper.mapToFitnessActivityDto(savedFitnessActivity);
    }

    public void deleteFitnessActivity(long fitnessActivityId){
        fitnessActivityDbService.deleteFitnessActivityById(fitnessActivityId);
    }


}
