package com.interview.koanba.model;

import com.interview.koanba.model.dto.CustomerDto;
import com.interview.koanba.model.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "customer")
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String customerId;
    private String customerName;
    private String address;
    private String phone;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
//    private Set<Order> order;

    public Customer(CustomerDto dto){
        this.customerName = dto.getCustomerName();
        this.address = dto.getAddress();
        this.phone = dto.getPhone();
    }

}
