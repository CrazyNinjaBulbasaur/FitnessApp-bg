package com.otakufitness.fitnessApp.repository;

import com.otakufitness.fitnessApp.domain.dailyJournal.DailyJournal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface DailyJournalRepository extends CrudRepository<DailyJournal, Long> {

    @Override
    List<DailyJournal> findAll();
}
