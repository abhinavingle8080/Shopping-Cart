package com.nctech.shoppingcart.Controller;

import com.nctech.shoppingcart.entity.Category;
import com.nctech.shoppingcart.service.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryServices categoryServices;

    @Autowired
   public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @PostMapping("/")
    public void save(@RequestBody Category category) {
        categoryServices.save(category);
    }

    @GetMapping("/{id}")
    public Category find(@PathVariable Integer id) {
        return categoryServices.findByID(id);
    }

    @GetMapping("/")
    public List<Category> findAll(){
        return categoryServices.findAll();
    }

    @PutMapping("/")
    public void update(@RequestBody Category category){
        categoryServices.update(category);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        categoryServices.delete(id);
    }
}
