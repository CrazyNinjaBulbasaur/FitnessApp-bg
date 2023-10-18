package com.otakufitness.fitnessApp.service.facade;


import com.otakufitness.fitnessApp.domain.dailyJournal.DailyJournal;
import com.otakufitness.fitnessApp.domain.dailyJournal.DailyJournalDto;
import com.otakufitness.fitnessApp.mapper.DailyJournalMapper;
import com.otakufitness.fitnessApp.repository.exceptions.DailyJournalNotFoundException;
import com.otakufitness.fitnessApp.service.DailyJournalDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyJournalFacade {

    private final DailyJournalDbService dailyJournalDbService;
    private final DailyJournalMapper dailyJournalMapper;

    public List<DailyJournalDto> getAllDailyJournals(){

        return dailyJournalDbService.getAllDailyJournals().stream()
                .map(dailyJournalMapper::mapToDailyJournalDto)
                .toList();
    }

    public DailyJournalDto getDailyJournalById(long dailyJournalId) throws DailyJournalNotFoundException {
        return dailyJournalMapper.mapToDailyJournalDto(dailyJournalDbService.getDailyJournalById(dailyJournalId));
    }

    public void addDailyJournal(DailyJournalDto dailyJournalDto){
        DailyJournal dailyJournal = dailyJournalMapper.mapToDailyJournal(dailyJournalDto);
        dailyJournalDbService.saveDailyJournal(dailyJournal);
    }

    public DailyJournalDto updateDailyJournal(DailyJournalDto dailyJournalDto){
        DailyJournal dailyJournal = dailyJournalMapper.mapToDailyJournal(dailyJournalDto);
        DailyJournal savedDailyJournal = dailyJournalDbService.saveDailyJournal(dailyJournal);

        return dailyJournalMapper.mapToDailyJournalDto(savedDailyJournal);
    }

    public void deleteDailyJournal(long dailyJournalId){
        dailyJournalDbService.deleteDailyJournalById(dailyJournalId);
    }

}
