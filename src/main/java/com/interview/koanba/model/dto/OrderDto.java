package com.interview.koanba.model.dto;

import com.interview.koanba.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {
    private String customerId;
    private List<Product> products;
}
