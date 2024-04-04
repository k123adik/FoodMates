package com.example.FoodMates.dto.responseDto;

import com.example.FoodMates.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class FoodResponseDto {

    String dishName;

    double price;

    FoodCategory foodCategory;

    boolean veg;
}
