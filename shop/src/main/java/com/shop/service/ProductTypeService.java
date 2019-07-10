package com.shop.service;

import com.shop.models.ProductType;

import java.util.ArrayList;
import java.util.Optional;

public interface ProductTypeService {
    ArrayList<ProductType> getAll();
    void delete(long t);
    void update(ProductType t);
    void add(ProductType t);
    Optional<ProductType> getById(long id);
}
