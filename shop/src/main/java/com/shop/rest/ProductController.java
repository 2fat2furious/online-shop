package com.shop.rest;


import com.shop.models.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @CrossOrigin
    @RequestMapping("/products")
    public ArrayList<Product> product() {
        return productService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public void saveOrUpdate(@RequestBody Product product)
    {
        productService.add(product);
    }

    @CrossOrigin
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name="id") String id)
    {
        productService.delete(Long.valueOf(id));
    }

    @CrossOrigin
    @GetMapping(value = "/products/{id}")
    public Product getById(@PathVariable(name="id") String id)
    {
        return productService.getById(Long.valueOf(id)).get();
    }
}
