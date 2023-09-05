package com.nctech.shoppingcart.service.impl;

import com.nctech.shoppingcart.entity.Product;
import com.nctech.shoppingcart.repository.ProductRepository;
import com.nctech.shoppingcart.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicesImpl implements ProductServices {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServicesImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findByID(Integer id) {
        return productRepository.findById(id).orElse(new Product());
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
