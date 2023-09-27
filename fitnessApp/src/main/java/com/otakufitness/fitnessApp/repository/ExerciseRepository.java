package com.otakufitness.fitnessApp.repository;

import com.otakufitness.fitnessApp.domain.Fitness.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ExerciseRepository extends CrudRepository <Exercise, Long> {

    @Override
//    <S extends Exercise> S save(S entity);
    Exercise save (Exercise exercise);

    @Override
    Optional<Exercise> findById(Long id);

    @Override
    List<Exercise> findAll();

    @Override
    void deleteById(Long id);
}
