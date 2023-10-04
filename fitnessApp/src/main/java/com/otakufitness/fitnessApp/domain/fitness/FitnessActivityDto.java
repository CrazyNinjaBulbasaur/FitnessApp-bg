package com.otakufitness.fitnessApp.domain.fitness;

import com.otakufitness.fitnessApp.domain.dailyJournal.DailyJournal;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FitnessActivityDto {
    private long id;
    private String duration;
    private Exercise exercise;
    private List<DailyJournal> dailyJournals;

}
