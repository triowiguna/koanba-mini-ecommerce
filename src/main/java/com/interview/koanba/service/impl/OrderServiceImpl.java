package com.interview.koanba.service.impl;

import com.interview.koanba.model.Customer;
import com.interview.koanba.model.Order;
import com.interview.koanba.model.Product;
import com.interview.koanba.model.dto.OrderDto;
import com.interview.koanba.repository.CustomerRepository;
import com.interview.koanba.repository.OrderRepository;
import com.interview.koanba.repository.ProductRepository;
import com.interview.koanba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Order createOrder(OrderDto dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId()).get();
        Order order = new Order(customer,dto);
        for (int i = 0; i < dto.getProducts().size() ; i++) {
            Product product = productRepository.findById(dto.getProducts().get(i).getProductId()).get();
            product.setStock(product.getStock()-dto.getProducts().get(i).getStock());
            productRepository.save(product);
        }
        return orderRepository.save(order);
    }
}
