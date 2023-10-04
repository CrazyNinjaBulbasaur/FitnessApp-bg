package com.otakufitness.fitnessApp.domain.Nutrition;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

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


}
