package com.interview.koanba.service;

import com.interview.koanba.model.Order;
import com.interview.koanba.model.dto.OrderDto;

public interface OrderService {
    public Order createOrder(OrderDto dto);
}
