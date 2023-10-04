package com.otakufitness.fitnessApp.service;

import com.otakufitness.fitnessApp.domain.dailyJournal.DailyJournal;
import com.otakufitness.fitnessApp.repository.DailyJournalRepository;
import com.otakufitness.fitnessApp.repository.exceptions.DailyJournalNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyJournalDbService {

    private final DailyJournalRepository repository;

    public List<DailyJournal> getAllDailyJournals(){
        return repository.findAll();
    }

    public DailyJournal saveDailyJournal(DailyJournal dailyJournal){
        return repository.save(dailyJournal);
    }

    public DailyJournal getDailyJournalById(Long id) throws DailyJournalNotFoundException {
        return repository.findById(id).orElseThrow( () -> new DailyJournalNotFoundException(id));
    }

    public void deleteDailyJournalById(long id){
        repository.deleteById(id);
    }
}
