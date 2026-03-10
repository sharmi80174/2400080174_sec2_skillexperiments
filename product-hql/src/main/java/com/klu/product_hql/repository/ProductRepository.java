package com.klu.product_hql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klu.product_hql.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

    // Sorting by price ASC
    @Query("FROM Product p ORDER BY p.price ASC")
    List<Product> sortPriceAsc();

    // Sorting by price DESC
    @Query("FROM Product p ORDER BY p.price DESC")
    List<Product> sortPriceDesc();

    // Sort by quantity highest first
    @Query("FROM Product p ORDER BY p.quantity DESC")
    List<Product> sortQuantity();

    // Count total products
    @Query("SELECT COUNT(p) FROM Product p")
    long countProducts();

    // Count where quantity > 0
    @Query("SELECT COUNT(p) FROM Product p WHERE p.quantity>0")
    long countAvailableProducts();

    // Group by description
    @Query("SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description")
    List<Object[]> groupByDescription();

    // Min price
    @Query("SELECT MIN(p.price) FROM Product p")
    double minPrice();

    // Max price
    @Query("SELECT MAX(p.price) FROM Product p")
    double maxPrice();

    // Price range
    @Query("FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> priceRange(double min,double max);

    // LIKE queries
    @Query("FROM Product p WHERE p.name LIKE ?1%")
    List<Product> nameStarts(String letter);

    @Query("FROM Product p WHERE p.name LIKE %?1")
    List<Product> nameEnds(String letter);

    @Query("FROM Product p WHERE p.name LIKE %?1%")
    List<Product> nameContains(String word);
}