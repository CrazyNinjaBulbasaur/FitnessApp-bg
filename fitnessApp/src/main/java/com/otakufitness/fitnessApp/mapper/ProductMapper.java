package com.otakufitness.fitnessApp.mapper;

import com.otakufitness.fitnessApp.domain.nutrition.Product;
import com.otakufitness.fitnessApp.domain.nutrition.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {
        return new Product.ProductBuilder()
                .id(productDto.getId())
                .name(productDto.getName())
                .grams(productDto.getGrams())
                .calories(productDto.getCalories())
                .carbohydrates(productDto.getCarbohydrates())
                .proteins(productDto.getProteins())
                .fats(productDto.getFats())
                .ingredients(productDto.getIngredients())
                .build();
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto.ProductDtoBuilder()
                .id(product.getId())
                .name(product.getName())
                .grams(product.getGrams())
                .calories(product.getCalories())
                .carbohydrates(product.getCarbohydrates())
                .proteins(product.getProteins())
                .fats(product.getFats())
                .ingredients(product.getIngredients())
                .build();
    }
}
