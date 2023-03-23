package com.example.shopping_cart.service;

import com.example.shopping_cart.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    void addToCart(Product product);
    void removeCart(Product product);
    Product findByIdProduct(Long idProduct);
    List<Product> getAllProducts();
    List<Product> getAllCart();
}
