package com.shop;

import com.shop.jdbc.ProductDAO;
import com.shop.jdbc.ProductDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;

@SpringBootApplication()
public class ShopApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(ShopApplication.class, args);
    }
}
