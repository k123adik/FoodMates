package com.example.FoodMates.service.impl;

import com.example.FoodMates.dto.requestDto.CustomerRequestDto;
import com.example.FoodMates.dto.responseDto.CustomerResponseDto;
import com.example.FoodMates.exception.CustomerNotFoundException;
import com.example.FoodMates.model.Cart;
import com.example.FoodMates.model.Customer;
import com.example.FoodMates.repository.CustomerRepository;
import com.example.FoodMates.service.CustomerService;
import com.example.FoodMates.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto){

        //dto to entity
        Customer customer = CustomerTransformer.customerRequestDtoToCustomer(customerRequestDto);

        //allocate a cart
        Cart cart = Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();

        customer.setCart(cart);

        //save both customer and cart
        Customer savedCustomer = customerRepository.save(customer);

        return CustomerTransformer.customerToCustomerResponseDto(savedCustomer);
    }

    @Override
    public CustomerResponseDto findCustomerByMobile(String mobileNo) throws CustomerNotFoundException {

        Customer customer = customerRepository.findByMobileNo(mobileNo);
        if(customer == null){
            throw new CustomerNotFoundException("Invalid Mobile Number!");
        }

        return CustomerTransformer.customerToCustomerResponseDto(customer);
    }
}
