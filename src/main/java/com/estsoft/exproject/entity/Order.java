package com.estsoft.exproject.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;

    @ManyToOne
    private Users user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    private LocalDateTime orderDate;
}
