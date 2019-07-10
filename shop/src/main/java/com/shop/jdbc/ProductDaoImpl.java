package com.shop.jdbc;

import com.shop.SpringJdbcConfig;
import com.shop.models.Product;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ProductDaoImpl implements ProductDAO
{

    @Override
    public ArrayList<Product> getAll()
    {
        ArrayList<Product> products = new ArrayList<>();
        try(Connection connection = SpringJdbcConfig.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Product");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                products.add(new Product(rs.getLong("id"), rs.getString("name"), rs.getBigDecimal("price"), rs.getString("skin_type"),
                        rs.getString("top_coat"), rs.getString("description"), rs.getLong("id"), rs.getLong("id"),
                        rs.getString("image")
                        ));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void add(Product product)
    {
        try(Connection connection = SpringJdbcConfig.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Product(name) VALUES(?)");
            String name = Objects.requireNonNull(product.getName(), "Unknown product");
            ps.setString(1,name);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id)
    {
        try(Connection connection = SpringJdbcConfig.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Product WHERE id = ?");
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product)
    {
        try(Connection connection = SpringJdbcConfig.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement("UPDATE Product SET name = ? WHERE id = ?");
            String name = Objects.requireNonNull(product.getName(), "Empty name");
            ps.setString(1, name);
            ps.setLong(2, product.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Product> getById(long id)
    {
        Optional<Product> maybeProduct = Optional.empty();
        try (Connection connection = SpringJdbcConfig.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Product WHERE id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                maybeProduct = Optional.of(new Product(rs.getLong("id"), rs.getString("name"), rs.getBigDecimal("price"), rs.getString("skin_type"),
                        rs.getString("top_coat"), rs.getString("description"), rs.getLong("type"), rs.getLong("brand"),
                        rs.getString("image")));

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return maybeProduct;
    }
}
