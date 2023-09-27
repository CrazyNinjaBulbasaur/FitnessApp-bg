package com.otakufitness.fitnessApp.domain.Nutrition;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="PRODUCT_ID", unique=true)
    private long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "GRAMS")
    private BigDecimal grams;
    @Column(name = "CALORIES")
    private BigDecimal calories;
    @Column(name = "CARBOHYDRATES")
    private BigDecimal carbohydrates;
    @Column(name = "FATS")
    private BigDecimal fats;
    @Column(name = "PROTEINS")
    private BigDecimal protein;

    @OneToMany(
            targetEntity = Ingredient.class,
            mappedBy = "product",
            fetch = FetchType.LAZY
    )
    private List<Ingredient> ingredients = new ArrayList<>();

}
