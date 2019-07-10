package com.shop.models;

import lombok.Getter;
import lombok.Setter;

public class Brand {

    public Brand(long id, String name, String description, String image)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.image=image;
    }

    @Override
    public String toString()
    {
        return String.format(
                "Brand[id=%d, name='%s', description='%s', image='%s']",
                id, name, description, image);
    }

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String image;

    public long getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
}
