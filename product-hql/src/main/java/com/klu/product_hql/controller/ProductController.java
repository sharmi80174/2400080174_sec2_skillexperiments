package com.klu.product_hql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.product_hql.entity.Product;
import com.klu.product_hql.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> allProducts(){
        return service.getAll();
    }

    @GetMapping("/sortpriceasc")
    public List<Product> sortAsc(){
        return service.sortPriceAsc();
    }

    @GetMapping("/sortpricedesc")
    public List<Product> sortDesc(){
        return service.sortPriceDesc();
    }

    @GetMapping("/sortquantity")
    public List<Product> sortQuantity(){
        return service.sortQuantity();
    }

    @GetMapping("/first3")
    public List<Product> first3(){
        return service.first3();
    }

    @GetMapping("/next3")
    public List<Product> next3(){
        return service.next3();
    }

    @GetMapping("/minprice")
    public double minPrice(){
        return service.minPrice();
    }

    @GetMapping("/maxprice")
    public double maxPrice(){
        return service.maxPrice();
    }
}