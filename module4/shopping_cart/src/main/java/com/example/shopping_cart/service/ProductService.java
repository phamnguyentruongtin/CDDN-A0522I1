package com.example.shopping_cart.service;

import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public void addToCart(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void removeCart(Product product) {
        iProductRepository.delete(product);
    }

    @Override
    public Product findByIdProduct(Long idProduct) {
        Product product = iProductRepository.findById(idProduct).orElseThrow(() -> new RuntimeException(""));
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(iProductRepository.findAll());
    }

    @Override
    public List<Product> getAllCart() {
        return iProductRepository.allCart();
    }
}
