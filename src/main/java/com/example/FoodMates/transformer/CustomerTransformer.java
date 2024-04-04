package com.example.FoodMates.transformer;

import com.example.FoodMates.dto.requestDto.CustomerRequestDto;
import com.example.FoodMates.dto.responseDto.CartResponseDto;
import com.example.FoodMates.dto.responseDto.CustomerResponseDto;
import com.example.FoodMates.model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){

        return Customer.builder()
                .name(customerRequestDto.getName())
                .emailId(customerRequestDto.getEmailId())
                .gender(customerRequestDto.getGender())
                .address(customerRequestDto.getAddress())
                .mobileNo(customerRequestDto.getMobileNo())
                .build();
    }

    public static CustomerResponseDto customerToCustomerResponseDto(Customer customer){

        CartResponseDto cartResponseDto = CartTransformer.cartToCartResponseDto(customer.getCart());

        return CustomerResponseDto.builder()
                .name(customer.getName())
                .mobileNo(customer.getMobileNo())
                .address(customer.getAddress())
                .cartResponseDto(cartResponseDto)
                .build();
    }
}
