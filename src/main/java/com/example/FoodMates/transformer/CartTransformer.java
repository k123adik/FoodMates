package com.example.FoodMates.transformer;

import com.example.FoodMates.dto.responseDto.CartResponseDto;
import com.example.FoodMates.dto.responseDto.FoodResponseDto;
import com.example.FoodMates.model.Cart;
import com.example.FoodMates.model.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class CartTransformer {

    public static CartResponseDto cartToCartResponseDto(Cart cart){

//        List<FoodResponseDto> foodResponseDtoList = new ArrayList<>();
//        for(FoodItem foodItem: cart.getFoodItemList()){
//            FoodResponseDto foodResponseDto = FoodItemTransformer.foodItemToFoodItemResponseDto(foodItem);
//            foodResponseDtoList.add(foodResponseDto);
//        }

        return CartResponseDto.builder()
                .cartTotal(cart.getCartTotal())
                .foodResponseDtoList(new ArrayList<>())
                .build();
    }
}
