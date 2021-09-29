package com.interview.koanba.service.impl;

import com.interview.koanba.model.Product;
import com.interview.koanba.model.dto.ProductDto;
import com.interview.koanba.repository.ProductRepository;
import com.interview.koanba.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product saveNewProduct(ProductDto dto) {
        return repository.save(new Product(dto));
    }

    @Override
    public Product editProduct(ProductDto dto, String productId) {
        Product product = repository.findById(productId).get();
        product.setProductPrice(dto.getProductPrice());
        product.setProductDescription(dto.getProductDescription());
        product.setStock(dto.getStock());
        return repository.save(product);
    }

    @Override
    public Product getProduct(String productId) {
        return repository.findById(productId).get();
    }
}
