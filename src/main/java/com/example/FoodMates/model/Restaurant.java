package com.example.FoodMates.model;

import com.example.FoodMates.Enum.RestaurantCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "restaurant")
@Builder
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    String location;

    @Enumerated(EnumType.STRING)
    RestaurantCategory restaurantCategory;

    @Column(unique = true, nullable = false)
    @Size(min = 10, max = 10)
    String contactNo;

    boolean opened;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    List<FoodItem> foodItemList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    List<OrderEntity> orderEntityList = new ArrayList<>();

}
