package com.nctech.shoppingcart.service;

import java.util.List;

public interface CRUDServices<T, K> {
    public void save(T value);
    public T findByID(K id);
    public List<T> findAll();
    public void update(T value);
    public void delete(K id);
}
