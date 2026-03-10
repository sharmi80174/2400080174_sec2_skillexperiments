package com.klu.product_hql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.klu.product_hql.entity.Product;
import com.klu.product_hql.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public List<Product> getAll(){
        return repo.findAll();
    }

    public List<Product> sortPriceAsc(){
        return repo.sortPriceAsc();
    }

    public List<Product> sortPriceDesc(){
        return repo.sortPriceDesc();
    }

    public List<Product> sortQuantity(){
        return repo.sortQuantity();
    }

    // pagination
    public List<Product> first3(){
        Pageable p=PageRequest.of(0,3);
        return repo.findAll(p).getContent();
    }

    public List<Product> next3(){
        Pageable p=PageRequest.of(1,3);
        return repo.findAll(p).getContent();
    }

    public long totalProducts(){
        return repo.countProducts();
    }

    public double minPrice(){
        return repo.minPrice();
    }

    public double maxPrice(){
        return repo.maxPrice();
    }
}