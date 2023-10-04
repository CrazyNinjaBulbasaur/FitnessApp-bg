package com.otakufitness.fitnessApp.domain.Nutrition;

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
public class Product {

    @Id
    @GeneratedValue
    @NotNull
    @Column(unique=true)
    private long id;

    @NotNull
    private String name;
    @NotNull
    private BigDecimal grams;
    private BigDecimal calories;
    private BigDecimal carbohydrates;
    private BigDecimal fats;
    private BigDecimal protein;

    @OneToMany(
            mappedBy = "product"
    )
    private List<Ingredient> ingredients;

}
