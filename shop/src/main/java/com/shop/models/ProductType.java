package com.shop.models;


import lombok.Getter;
import lombok.Setter;

public class ProductType {
    private long id;
    private String name, category;

    public ProductType(long id, String name, String category, String image)
    {
        this.id = id;
        this.name = name;
        this.category = category;
        this.image=image;
    }

    @Override
    public String toString()
    {
        return String.format(
                "Product_type[id=%d, name='%s', category='%s', image='%s']",
                id, name, category, image);
    }

    public void setCategory(String value)
    {
        category = value;
    }
    public void setName(String value)
    {
        name=value;
    }
    public void setId(long value)
    {
        id = value;
    }
    public long getId()
    {
        return id;
    }
    public String getCategory()
    {
        return category;
    }
    public String getName()
    {
        return name;
    }
    @Getter
    @Setter
    private String image;
}
