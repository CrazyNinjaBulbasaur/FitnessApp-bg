package com.otakufitness.fitnessApp.domain.fitness;

import com.otakufitness.fitnessApp.domain.dailyJournal.DailyJournal;
import com.otakufitness.fitnessApp.domain.dailyJournal.DailyJournalEntry;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FitnessActivity implements DailyJournalEntry {
    @Id
    @GeneratedValue
    @NotNull
    @Column(unique=true)
    private long id;

    @NotNull
    private String duration;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "EXERCISE_ID")
    private Exercise exercise;

    @ManyToMany(mappedBy = "fitnessActivities")
    private List<DailyJournal> dailyJournals;
}
