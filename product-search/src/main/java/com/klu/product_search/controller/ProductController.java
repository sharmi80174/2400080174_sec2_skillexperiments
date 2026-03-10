package com.klu.product_search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.product_search.entity.Product;
import com.klu.product_search.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    // Add product
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    // Find products by category
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // Filter products between price range
    @GetMapping("/filter")
    public List<Product> filterProducts(@RequestParam double min,
                                        @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    // Sort products by price
    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return repo.sortProductsByPrice();
    }

    // Fetch products above given price
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensiveProducts(@PathVariable double price) {
        return repo.findExpensiveProducts(price);
    }
}