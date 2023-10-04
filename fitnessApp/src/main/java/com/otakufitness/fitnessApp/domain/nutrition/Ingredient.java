package com.otakufitness.fitnessApp.domain.nutrition;

import com.otakufitness.fitnessApp.domain.dailyJournal.DailyJournal;
import com.otakufitness.fitnessApp.domain.dailyJournal.DailyJournalEntry;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient implements DailyJournalEntry {

    @Id
    @GeneratedValue
    @NotNull
    @Column(unique=true)
    private long id;

    @NotNull
    private BigDecimal grams;

    @ManyToOne()
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToMany(mappedBy = "ingredients")
    private List<DailyJournal> dailyJournals;

}
