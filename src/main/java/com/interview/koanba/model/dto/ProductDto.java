package com.interview.koanba.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProductDto {
    private Long productPrice;
    private String productDescription;
    private Integer stock;
}
