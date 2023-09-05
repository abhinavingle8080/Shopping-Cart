package com.nctech.shoppingcart.Controller;

import com.nctech.shoppingcart.entity.Category;
import com.nctech.shoppingcart.entity.Product;
import com.nctech.shoppingcart.service.CategoryServices;
import com.nctech.shoppingcart.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductServices productServices;
    private final CategoryServices categoryServices;

    @Autowired
    public ProductController(ProductServices productServices, CategoryServices categoryServices) {
        this.productServices = productServices;
        this.categoryServices = categoryServices;
    }

    @PostMapping("/")
    public void save(@RequestBody Product product) {
        productServices.save(product);
        Category category = categoryServices.findByID(product.getCategory().getId());
        category.getProducts().add(product);
        categoryServices.update(category);
    }

    @GetMapping("/{id}")
    public Product find(@PathVariable Integer id) {
        return productServices.findByID(id);
    }

    @GetMapping("/")
    public List<Product> findAll() {
        return productServices.findAll();
    }

    @PutMapping("/")
    public void update(@RequestBody Product product) {
        productServices.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productServices.delete(id);
    }
}
