package com.example.FoodMates.controller;

import com.example.FoodMates.dto.requestDto.CustomerRequestDto;
import com.example.FoodMates.dto.responseDto.CustomerResponseDto;
import com.example.FoodMates.exception.CustomerNotFoundException;
import com.example.FoodMates.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        CustomerResponseDto customerResponseDto = customerService.addCustomer(customerRequestDto);
        return new ResponseEntity<>(customerResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/find/mobileNo/{mobileNo}")
    public ResponseEntity getCustomerByMobile(@PathVariable("mobileNo") String mobileNo){
        try{
            CustomerResponseDto customerResponseDto = customerService.findCustomerByMobile(mobileNo);
            return new ResponseEntity<>(customerResponseDto, HttpStatus.FOUND);
        }
        catch(CustomerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
