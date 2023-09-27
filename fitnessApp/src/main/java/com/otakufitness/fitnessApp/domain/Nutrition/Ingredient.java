package com.otakufitness.fitnessApp.domain.Nutrition;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "INGREDIENTS")
public class Ingredient {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="PRODUCT_ID", unique=true)
    private long id;

    @NotNull
    @Column(name = "GRAMS")
    private BigDecimal grams;


    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;


}
