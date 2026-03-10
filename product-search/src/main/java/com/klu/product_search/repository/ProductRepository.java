package com.klu.product_search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.klu.product_search.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

    // Derived query methods
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min,double max);

    // JPQL sorting
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> sortProductsByPrice();

    // JPQL expensive products
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findExpensiveProducts(double price);

    // JPQL category search
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> getProductsByCategory(String category);
}