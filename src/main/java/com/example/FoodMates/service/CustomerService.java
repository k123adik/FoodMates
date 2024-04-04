package com.example.FoodMates.service;

import com.example.FoodMates.dto.requestDto.CustomerRequestDto;
import com.example.FoodMates.dto.responseDto.CustomerResponseDto;
import com.example.FoodMates.exception.CustomerNotFoundException;

public interface CustomerService {

    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto);

    CustomerResponseDto findCustomerByMobile(String mobileNo) throws CustomerNotFoundException;
}
