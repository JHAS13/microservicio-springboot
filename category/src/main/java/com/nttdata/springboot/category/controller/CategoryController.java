package com.nttdata.springboot.category.controller;


import com.nttdata.springboot.category.model.Category;
import com.nttdata.springboot.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    @Value("${category.dato}")
    private String dato;

    @GetMapping("/category")
    public Category getCategory(){
        return categoryService.getCategory();
    }

    @GetMapping("/propertie")
    public String getPropertie(){
        return dato;
    }


}
