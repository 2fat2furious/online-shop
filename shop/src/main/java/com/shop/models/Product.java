package com.shop.models;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

public class Product {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private BigDecimal price;
    @Getter
    @Setter
    private String skin_type;
    @Getter
    @Setter
    private String top_coat;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private long id_brand;
    @Getter
    @Setter
    private long type_id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String image;

    public Product(long id, String name, BigDecimal price, String skin_type,
                   String top_coat, String description, long id_brand, long type_id, String image)
    {
        this.id=id;
        this.name=name;
        this.price=price;
        this.skin_type=skin_type;
        this.top_coat=top_coat;
        this.description=description;
        this.id_brand=id_brand;
        this.type_id=type_id;
        this.image=image;
    }

    @Override
    public String toString()
    {
        return String.format(
                "Product[id=%d, name='%s', price=%d, skin_type='%s', top_coat='%s', description='%s',id_brand=%d, type_id=%d]",
                id, name, price, skin_type, top_coat, description,id_brand,type_id);
    }

    public long getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }



}
