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
            name = "JOIN_DAILYJOURNALS_INGREDIENTS",
            joinColumns = {@JoinColumn(name = "DAILYJOURNAL_ID", referencedColumnName = "DAILYJOURNAL_ID")},
            inverseJoinColumns = {@JoinColumn(name = "INGREDIENT_ID", referencedColumnName = "INGREDIENT_ID")}
    )
    private List<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(
            name = "JOIN_DAILYJOURNALS_FITNESSACTIVITIES",
            joinColumns = {@JoinColumn(name = "DAILYJOURNAL_ID", referencedColumnName = "DAILYJOURNAL_ID")},
            inverseJoinColumns = {@JoinColumn(name = "FITNESSACTIVITY_ID", referencedColumnName = "FITNESSACTIVITY_ID")}
    )
    private List<FitnessActivity> fitnessActivities;

}
