package com.example.FoodMates.transformer;

import com.example.FoodMates.dto.responseDto.FoodResponseDto;
import com.example.FoodMates.model.FoodItem;

public class FoodItemTransformer {

    public static FoodResponseDto foodItemToFoodItemResponseDto(FoodItem foodItem){

        return FoodResponseDto.builder()
                .dishName(foodItem.getDishName())
                .price(foodItem.getPrice())
                .foodCategory(foodItem.getFoodCategory())
                .veg(foodItem.isVeg())
                .build();
    }
}
