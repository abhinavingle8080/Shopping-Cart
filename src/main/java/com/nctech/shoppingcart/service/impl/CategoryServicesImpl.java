package com.nctech.shoppingcart.service.impl;

import com.nctech.shoppingcart.entity.Category;
import com.nctech.shoppingcart.repository.CategoryRepository;
import com.nctech.shoppingcart.service.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServicesImpl implements CategoryServices {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServicesImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findByID(Integer id) {
        return categoryRepository.findById(id).orElse(new Category());
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
