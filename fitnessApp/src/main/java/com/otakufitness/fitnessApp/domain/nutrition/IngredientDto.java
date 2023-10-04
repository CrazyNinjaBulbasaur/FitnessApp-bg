package com.otakufitness.fitnessApp.domain.nutrition;

import com.otakufitness.fitnessApp.domain.dailyJournal.DailyJournal;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class IngredientDto {
    private long id;
    private BigDecimal grams;
    private Product product;
    private List<DailyJournal> dailyJournals;
}
