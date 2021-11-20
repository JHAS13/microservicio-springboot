package com.nttdata.springboot.category.controller;


import com.nttdata.springboot.category.model.Category;
import com.nttdata.springboot.category.service.CategoryProjection;
import com.nttdata.springboot.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    @Value("${category.dato}")
    private String dato;

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable Integer id)
    {
        return categoryService.getCategory(id);
    }

    @GetMapping("/category")
    public List<Category> getCategory()
    {
        return categoryService.getCategoryAll();
    }

    @PostMapping("/category")
    public void saveCategory(@RequestBody Category category)
    {
         categoryService.save(category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Integer id)
    {
        categoryService.deleteById(id);
    }

    @GetMapping("/category/price/{price}")
    public List<Category> getCategoryByPrice(@PathVariable Double price)
    {
        return categoryService.getCategoryByPrice(price);
    }

    @GetMapping("/category/type/{type}")
    public List<Category> getCategoryByType(@PathVariable String type)
    {
        return categoryService.getCategoryByType(type);
    }

    @GetMapping("/category/typeP/{type}")
    public List<CategoryProjection> getCategoryByTypeP(@PathVariable String type)
    {
        return categoryService.getCategoryProjectionByType(type);
    }

    @GetMapping("/propertie")
    public String getPropertie(){
        return dato;
    }




}
