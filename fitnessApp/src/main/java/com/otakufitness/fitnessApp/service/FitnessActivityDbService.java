package com.otakufitness.fitnessApp.service;

import com.otakufitness.fitnessApp.domain.fitness.FitnessActivity;
import com.otakufitness.fitnessApp.repository.FitnessActivityRepository;
import com.otakufitness.fitnessApp.repository.exceptions.FitnessActivityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FitnessActivityDbService {

    private final FitnessActivityRepository repository;

    public List<FitnessActivity> getAllFitnessActivities(){
        return repository.findAll();
    }

    public FitnessActivity saveFitnessActivity(FitnessActivity fitnessActivity){
        return repository.save(fitnessActivity);
    }

    public FitnessActivity getFitnessActivityById(Long id) throws FitnessActivityNotFoundException {
        return repository.findById(id).orElseThrow( () -> new FitnessActivityNotFoundException(id));
    }

    public void deleteFitnessActivityById(long id){
        repository.deleteById(id);
    }
}
