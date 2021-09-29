package com.interview.koanba.controller;

import com.interview.koanba.model.Order;
import com.interview.koanba.model.dto.OrderDto;
import com.interview.koanba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("/add")
    public Order createOrder (@RequestBody OrderDto dto){
        return service.createOrder(dto);
    }
}
