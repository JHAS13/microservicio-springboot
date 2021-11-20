package com.nttdata.springboot.category.service;

import com.nttdata.springboot.category.model.Category;

import java.util.List;

public interface CategoryService {

    Category getCategory(Integer id);
    List<Category> getCategoryAll();
    void save(Category category);
    void  deleteById(Integer id);

    List<Category> getCategoryByPrice(Double price);
    List<Category> getCategoryByType(String  type);
    List<CategoryProjection> getCategoryProjectionByType(String  type);

}
