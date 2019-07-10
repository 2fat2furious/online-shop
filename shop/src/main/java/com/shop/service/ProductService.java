package com.shop.service;

import com.shop.models.Product;

import java.util.ArrayList;
import java.util.Optional;

public interface ProductService {
    ArrayList<Product> getAll();
    void delete(long t);
    void update(Product t);
    void add(Product t);
    Optional<Product> getById(long id);
}
