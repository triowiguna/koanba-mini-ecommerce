package com.interview.koanba.model;

import com.interview.koanba.model.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product")
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productId;
    private Long productPrice;
    private String productDescription;
    private Integer stock;

    public Product(ProductDto dto){
        this.productPrice = dto.getProductPrice();
        this.productDescription = dto.getProductDescription();
        this.stock = dto.getStock();
    }
}
