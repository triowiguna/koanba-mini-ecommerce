package com.interview.koanba.model;

import com.interview.koanba.model.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orderProduct")
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderId;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    private String customerName;
    private Long amount;
    private Integer quantity;
    @CreationTimestamp
    private Date orderDate;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Product> products;

    public Order(Customer customer1, OrderDto dto){
        this.customer = customer1;
        this.customerName = customer1.getCustomerName();
        long totalPrice = 0L;
        for (Product product : dto.getProducts()) {
            totalPrice = totalPrice + (product.getProductPrice()*product.getStock());
        }
        this.amount = totalPrice;
        int totalQuantity = 0;
        for (int i = 0; i < dto.getProducts().size() ; i++) {
            totalQuantity = totalQuantity+dto.getProducts().get(i).getStock();
        }
        this.quantity = totalQuantity;
        this.products = dto.getProducts();
    }
}
