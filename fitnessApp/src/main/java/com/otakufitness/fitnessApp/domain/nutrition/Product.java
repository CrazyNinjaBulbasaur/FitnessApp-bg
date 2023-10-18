package com.otakufitness.fitnessApp.domain.nutrition;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    private BigDecimal proteins;

    @OneToMany(
            mappedBy = "product"
    )
    private List<Ingredient> ingredients;

    public static class ProductBuilder {

        private long id;
        private String name;
        private BigDecimal grams;
        private BigDecimal calories;
        private BigDecimal carbohydrates;
        private BigDecimal fats;
        private BigDecimal proteins;
        private List<Ingredient> ingredients;

        public ProductBuilder id(long id) {
            this.id = id;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder grams(BigDecimal grams) {
            this.grams = grams;
            return this;
        }

        public ProductBuilder calories(BigDecimal calories) {
            this.calories = calories;
            return this;
        }

        public ProductBuilder carbohydrates(BigDecimal carbohydrates) {
            this.carbohydrates = carbohydrates;
            return this;
        }

        public ProductBuilder fats(BigDecimal fats) {
            this.fats = fats;
            return this;
        }

        public ProductBuilder proteins(BigDecimal proteins) {
            this.proteins = proteins;
            return this;
        }

        public ProductBuilder ingredients(List<Ingredient> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Product build() {
            return new Product(id, name, grams, calories, carbohydrates, fats, proteins, ingredients);
        }
    }
}
