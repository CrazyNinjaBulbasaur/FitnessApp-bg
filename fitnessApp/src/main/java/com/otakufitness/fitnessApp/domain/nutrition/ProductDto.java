package com.otakufitness.fitnessApp.domain.nutrition;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductDto {

    private long id;
    private String name;
    private BigDecimal grams;
    private BigDecimal calories;
    private BigDecimal carbohydrates;
    private BigDecimal fats;
    private BigDecimal proteins;
    private List<Ingredient> ingredients;

    public static class ProductDtoBuilder {

        private long id;
        private String name;
        private BigDecimal grams;
        private BigDecimal calories;
        private BigDecimal carbohydrates;
        private BigDecimal fats;
        private BigDecimal proteins;
        private List<Ingredient> ingredients;

        public ProductDtoBuilder id(long id) {
            this.id = id;
            return this;
        }

        public ProductDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductDtoBuilder grams(BigDecimal grams) {
            this.grams = grams;
            return this;
        }

        public ProductDtoBuilder calories(BigDecimal calories) {
            this.calories = calories;
            return this;
        }

        public ProductDtoBuilder carbohydrates(BigDecimal carbohydrates) {
            this.carbohydrates = carbohydrates;
            return this;
        }

        public ProductDtoBuilder fats(BigDecimal fats) {
            this.fats = fats;
            return this;
        }

        public ProductDtoBuilder proteins(BigDecimal proteins) {
            this.proteins = proteins;
            return this;
        }

        public ProductDtoBuilder ingredients(List<Ingredient> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public ProductDto build() {
            return new ProductDto(id, name, grams, calories, carbohydrates, fats, proteins, ingredients);
        }
    }
}
