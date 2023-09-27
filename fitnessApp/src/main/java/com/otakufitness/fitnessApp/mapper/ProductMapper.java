package com.otakufitness.fitnessApp.mapper;

import com.otakufitness.fitnessApp.domain.Nutrition.Product;
import com.otakufitness.fitnessApp.domain.Nutrition.ProductDto;

public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(productDto.getId(),
                productDto.getName(),
                productDto.getGrams(),
                productDto.getCalories(),
                productDto.getCarbohydrates(),
                productDto.getFats(),
                productDto.getProtein(),
                productDto.getIngredients()
        );
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getGrams(),
                product.getCalories(),
                product.getCarbohydrates(),
                product.getFats(),
                product.getProtein(),
                product.getIngredients()
        );
    }
}
