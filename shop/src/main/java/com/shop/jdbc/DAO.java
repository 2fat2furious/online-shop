package com.shop.jdbc;

import java.util.ArrayList;
import java.util.Optional;

public interface DAO <T> {

    ArrayList<T> getAll();
    void delete(long id);
    void update(T t);
    void add(T t);
    Optional<T> getById(long id);
}
