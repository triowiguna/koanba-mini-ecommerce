package com.interview.koanba.controller;

import com.interview.koanba.model.Product;
import com.interview.koanba.model.dto.ProductDto;
import com.interview.koanba.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public Product addNewProduct(@RequestBody ProductDto product){
        return service.saveNewProduct(product);
    }

    @PutMapping("/edit/{productId}")
    public Product editProduct(@RequestBody ProductDto product,@PathVariable String productId){
        return service.editProduct(product,productId);
    }

    @GetMapping("/get/{productId}")
    public Product getProduct(@PathVariable String productId){
        return service.getProduct(productId);
    }
}
