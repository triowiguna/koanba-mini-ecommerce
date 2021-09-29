package com.interview.koanba.service.impl;

import com.interview.koanba.model.Customer;
import com.interview.koanba.model.Product;
import com.interview.koanba.model.dto.CustomerDto;
import com.interview.koanba.model.dto.ProductDto;
import com.interview.koanba.repository.CustomerRepository;
import com.interview.koanba.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public Customer saveNewCustomer(CustomerDto dto) {
        return repository.save(new Customer(dto));
    }

    @Override
    public Customer editCustomer(CustomerDto dto, String customerId) {
        Customer customer = repository.findById(customerId).get();
        customer.setCustomerName(dto.getCustomerName());
        customer.setAddress(dto.getAddress());
        customer.setPhone(dto.getPhone());
        return repository.save(customer);
    }

    @Override
    public Customer getCustomer(String customerId) {
        return repository.findById(customerId).get();
    }
}
