package com.shop.service;

import com.shop.models.Brand;

import java.util.ArrayList;
import java.util.Optional;

public interface BrandService {
    ArrayList<Brand> getAll();
    void delete(long t);
    void update(Brand t);
    void add(Brand t);
    Optional<Brand> getById(long id);
}
