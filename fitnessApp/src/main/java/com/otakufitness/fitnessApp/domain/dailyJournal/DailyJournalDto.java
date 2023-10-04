package com.otakufitness.fitnessApp.domain.dailyJournal;

import com.otakufitness.fitnessApp.domain.fitness.FitnessActivity;
import com.otakufitness.fitnessApp.domain.nutrition.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class DailyJournalDto {

    private long id;
    private LocalDate date;
//    private List<DailyJournalEntry> journalEntries;

    private List<Ingredient> ingredients;
    private List<FitnessActivity> fitnessActivities;
}
