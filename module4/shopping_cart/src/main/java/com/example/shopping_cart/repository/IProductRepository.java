package com.example.shopping_cart.repository;

import com.example.shopping_cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * from product where client_id_client != null",nativeQuery = true)
    default List<Product> allCart(){
        return new ArrayList<>();
    }
}
