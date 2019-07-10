package com.shop.jdbc;

import com.shop.SpringJdbcConfig;
import com.shop.models.Brand;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Repository
public class BrandDaoImpl implements BrandDAO {

    @Override
    public ArrayList<Brand> getAll()
    {
        ArrayList<Brand> brands = new ArrayList<>();
        try(Connection connection = SpringJdbcConfig.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Brand");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                brands.add(new Brand(rs.getLong("id"),
                        rs.getString("name"), rs.getString("description"),
                        rs.getString("image")));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return brands;
    }

    @Override
    public void add(Brand brand)
    {
        try(Connection connection = SpringJdbcConfig.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Brand(name) VALUES(?)");
            String name = Objects.requireNonNull(brand.getName(), "Unknown brand");
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
    public void update(Brand brand)
    {
        try(Connection connection = SpringJdbcConfig.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement("UPDATE Brand SET name = ? WHERE id = ?");
            String name = Objects.requireNonNull(brand.getName(), "Empty name");
            ps.setString(1, name);
            ps.setLong(2, brand.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Brand> getById(long id)
    {
        Optional<Brand> maybeBrand = Optional.empty();
        try (Connection connection = SpringJdbcConfig.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Brand WHERE id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                maybeBrand = Optional.of(new Brand(rs.getLong("id"),
                        rs.getString("name"), rs.getString("description"),
                        rs.getString("image")));

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return maybeBrand;
    }
}
