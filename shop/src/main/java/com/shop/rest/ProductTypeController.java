package com.shop.rest;

import com.shop.jdbc.ProductTypeDAO;
import com.shop.jdbc.ProductTypeDaoImpl;
import com.shop.models.Product;
import com.shop.models.ProductType;
import com.shop.service.ProductService;
import com.shop.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    @CrossOrigin
    @RequestMapping("/types")
    public ArrayList<ProductType> productType() {
        return productTypeService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/types", method = RequestMethod.POST)
    public void saveOrUpdate(@RequestBody ProductType productType)
    {
        productTypeService.add(productType);
    }

    @CrossOrigin
    @RequestMapping(value = "/types", method = RequestMethod.DELETE)
    public void delete(@RequestBody long id)
    {
        productTypeService.delete(id);
    }
}
