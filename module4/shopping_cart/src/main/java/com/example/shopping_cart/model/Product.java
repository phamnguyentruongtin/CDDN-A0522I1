package com.example.shopping_cart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;
    private String name_product;
    private String product_from;
    private String date;
    private String category_of_product;
    @ManyToOne
    @JoinColumn
    private Client client;
}
