package com.shop.service.impl;

import com.shop.jdbc.ProductDAO;
import com.shop.models.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public void add(Product product)
    {
        if(productDAO.getById(product.getId()).isPresent()){
            productDAO.update(product);
        } else {
            productDAO.add(product);
        }
    }

    @Override
    public void delete(long id)
    {
        productDAO.delete(id);
    }

    @Override
    public void update(Product product)
    {
        productDAO.update(product);
    }

    @Override
    public Optional<Product> getById(long id)
    {
        Optional<Product> maybeProduct = productDAO.getById(id);

        return maybeProduct;
    }

    @Override
    public ArrayList<Product> getAll()
    {
        return productDAO.getAll();
    }
}
