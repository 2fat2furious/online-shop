package com.shop.service.impl;

import com.shop.jdbc.ProductTypeDAO;
import com.shop.models.ProductType;
import com.shop.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDAO productTypeDAO;

    @Override
    public void add(ProductType type)
    {
        productTypeDAO.add(type);
    }

    @Override
    public void delete(long id)
    {
        productTypeDAO.delete(id);
    }

    @Override
    public void update(ProductType type)
    {
        productTypeDAO.update(type);
    }

    @Override
    public Optional<ProductType> getById(long id)
    {
        Optional<ProductType> maybeType = productTypeDAO.getById(id);

        return maybeType;
    }

    @Override
    public ArrayList<ProductType> getAll()
    {
        return productTypeDAO.getAll();
    }

}
