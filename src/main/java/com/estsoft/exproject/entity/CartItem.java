package com.estsoft.exproject.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product product;

    private int quantity;
}
