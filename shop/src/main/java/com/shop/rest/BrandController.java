package com.shop.rest;

import com.shop.jdbc.BrandDAO;
import com.shop.jdbc.BrandDaoImpl;
import com.shop.models.Brand;
import com.shop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BrandController {

    @Autowired
    BrandService brandService;

    @CrossOrigin
    @RequestMapping("/brands")
    public ArrayList<Brand> brand() {
        return brandService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/brands", method = RequestMethod.POST)
    public void saveOrUpdate(@RequestBody Brand brand)
    {
        brandService.add(brand);
    }

    @CrossOrigin
    @RequestMapping(value = "/brands", method = RequestMethod.DELETE)
    public void delete(@RequestBody long id)
    {
        brandService.delete(id);
    }
}
