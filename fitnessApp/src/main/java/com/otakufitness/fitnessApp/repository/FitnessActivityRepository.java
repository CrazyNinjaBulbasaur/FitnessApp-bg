package com.otakufitness.fitnessApp.repository;


import com.otakufitness.fitnessApp.domain.Fitness.Exercise;
import com.otakufitness.fitnessApp.domain.Fitness.FitnessActivity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface FitnessActivityRepository  extends CrudRepository<FitnessActivity, Long> {
    @Override
//    <S extends Exercise> S save(S entity);
    FitnessActivity save (FitnessActivity fitnessActivity);

    @Override
    Optional<FitnessActivity> findById(Long id);

    @Override
    List<FitnessActivity> findAll();

    @Override
    void deleteById(Long id);

}
