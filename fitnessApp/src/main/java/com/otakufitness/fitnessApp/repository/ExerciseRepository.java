package com.otakufitness.fitnessApp.repository;

import com.otakufitness.fitnessApp.domain.Fitness.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ExerciseRepository extends CrudRepository <Exercise, Long> {

    @Override
    List<Exercise> findAll();

}
