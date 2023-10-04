package com.otakufitness.fitnessApp.repository;

import com.otakufitness.fitnessApp.domain.Fitness.FitnessActivity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface FitnessActivityRepository  extends CrudRepository<FitnessActivity, Long> {

    @Override
    List<FitnessActivity> findAll();


}
