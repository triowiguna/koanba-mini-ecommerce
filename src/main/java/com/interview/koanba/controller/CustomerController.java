package com.interview.koanba.controller;

import com.interview.koanba.model.Customer;
import com.interview.koanba.model.Product;
import com.interview.koanba.model.dto.CustomerDto;
import com.interview.koanba.model.dto.ProductDto;
import com.interview.koanba.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/add")
    public Customer addNewProduct(@RequestBody CustomerDto dto){
        return service.saveNewCustomer(dto);
    }

    @PutMapping("/edit/{customerId}")
    public Customer editProduct(@RequestBody CustomerDto dto,@PathVariable String customerId){
        return service.editCustomer(dto,customerId);
    }

    @GetMapping("/get/{customerId}")
    public Customer getProduct(@PathVariable String customerId){
        return service.getCustomer(customerId);
    }
}
