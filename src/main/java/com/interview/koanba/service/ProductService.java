package com.interview.koanba.service;

import com.interview.koanba.model.Product;
import com.interview.koanba.model.dto.ProductDto;

import java.util.UUID;

public interface ProductService {
    public Product saveNewProduct(ProductDto dto);
    public Product editProduct(ProductDto dto, String productId);
    public Product getProduct(String productId);
}
