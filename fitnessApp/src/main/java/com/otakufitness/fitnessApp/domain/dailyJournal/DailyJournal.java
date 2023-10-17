package com.otakufitness.fitnessApp.domain.dailyJournal;

import com.otakufitness.fitnessApp.domain.fitness.FitnessActivity;
import com.otakufitness.fitnessApp.domain.nutrition.Ingredient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyJournal {
    @Id
    @GeneratedValue
    @NotNull
    @Column(unique=true)
    private long id;
    private LocalDate date;

//    @ManyToMany
//    private List<DailyJournalEntry> journalEntries;

    @ManyToMany
    @JoinTable(
            name = "JOIN_DAILY_JOURNALS_INGREDIENTS",
            joinColumns = {@JoinColumn(name = "daily_journal_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient")}
    )
    private List<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(
            name = "JOIN_DAILY_JOURNALS_FITNESSACTIVITIES",
            joinColumns = {@JoinColumn(name = "daily_journal_id")},
            inverseJoinColumns = {@JoinColumn(name = "fitness_activity_id")}
    )
    private List<FitnessActivity> fitnessActivities;

}
