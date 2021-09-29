package com.interview.koanba.service;

import com.interview.koanba.model.Customer;
import com.interview.koanba.model.Product;
import com.interview.koanba.model.dto.CustomerDto;
import com.interview.koanba.model.dto.ProductDto;

import java.util.UUID;

public interface CustomerService {
    public Customer saveNewCustomer(CustomerDto dto);
    public Customer editCustomer(CustomerDto dto, String productId);
    public Customer getCustomer(String productId);
}
