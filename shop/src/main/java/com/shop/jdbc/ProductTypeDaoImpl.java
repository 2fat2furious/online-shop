package com.shop.jdbc;

import com.shop.SpringJdbcConfig;
import com.shop.models.ProductType;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ProductTypeDaoImpl implements ProductTypeDAO {

    @Override
    public Optional<ProductType> getById(long id)
    {
        Optional<ProductType> maybeProduct_type = Optional.empty();
        try(Connection connection = SpringJdbcConfig.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Type WHERE id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                maybeProduct_type = Optional.of(new ProductType(rs.getLong("id"),
                                    rs.getString("name"), rs.getString("category"),
                                    rs.getString("image")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maybeProduct_type;
    }

    @Override
    public void add(ProductType product_type)
    {
        try(Connection connection = SpringJdbcConfig.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Type(name) VALUES(?)");
            String name = Objects.requireNonNull(product_type.getName(), "Unknown product_type");
            ps.setString(1,name);
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id)
    {
        try(Connection connection = SpringJdbcConfig.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Type WHERE id = ?");
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ProductType product_type)
    {
        try(Connection connection = SpringJdbcConfig.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement("UPDATE Type SET name = ? WHERE id = ?");
            String name = Objects.requireNonNull(product_type.getName(), "Empty name");
            ps.setString(1, name);
            ps.setLong(2, product_type.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public ArrayList<ProductType> getAll()
    {
        ArrayList<ProductType> product_types = new ArrayList<>();
        try(Connection connection = SpringJdbcConfig.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Type");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                product_types.add(new ProductType(rs.getLong("id"), rs.getString("name"),
                        rs.getString("category"),rs.getString("image")));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return product_types;
    }
}
