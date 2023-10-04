package com.otakufitness.fitnessApp.mapper;

import com.otakufitness.fitnessApp.domain.dailyJournal.DailyJournal;
import com.otakufitness.fitnessApp.domain.dailyJournal.DailyJournalDto;
import org.springframework.stereotype.Component;

@Component
public class DailyJournalMapper {

    public DailyJournal mapToDailyJournal(final DailyJournalDto dailyJournalDto){
        return new DailyJournal(
            dailyJournalDto.getId(),
            dailyJournalDto.getDate(),
//            dailyJournalDto.getJournalEntries(),
                dailyJournalDto.getIngredients(),
                dailyJournalDto.getFitnessActivities()
        );
    }

    public DailyJournalDto mapToDailyJournalDto(final DailyJournal dailyJournal){
        return new DailyJournalDto(
                dailyJournal.getId(),
                dailyJournal.getDate(),
//            dailyJournalDto.getJournalEntries(),
                dailyJournal.getIngredients(),
                dailyJournal.getFitnessActivities()
        );
    }
}
