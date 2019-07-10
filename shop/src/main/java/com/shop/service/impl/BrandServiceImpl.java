package com.shop.service.impl;

import com.shop.jdbc.BrandDAO;
import com.shop.models.Brand;
import com.shop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDAO brandDAO;

    @Override
    public void add(Brand brand) {
        brandDAO.add(brand);
    }

    @Override
    public void delete(long id) {
        brandDAO.delete(id);
    }

    @Override
    public void update(Brand brand) {
        brandDAO.update(brand);
    }

    @Override
    public Optional<Brand> getById(long id) {
        return brandDAO.getById(id);
    }

    @Override
    public ArrayList<Brand> getAll() {
        return brandDAO.getAll();
    }

}
