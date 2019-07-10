CREATE TABLE Type(id serial PRIMARY KEY,
                          name varchar(20),
                          category varchar(10));

CREATE TABLE Brand(id serial PRIMARY KEY,
                   name varchar(20),
                   description text);

CREATE TABLE Product(id serial PRIMARY KEY,
                    name varchar(20),
                    price money CHECK (price>0),
                    color varchar(15),
                    skin_type varchar(15),
                    top_coat varchar(10),
                    description text,
                    Brand int REFERENCES Brand(id) ON DELETE CASCADE,
                    Type int REFERENCES Type(id) ON DELETE CASCADE);