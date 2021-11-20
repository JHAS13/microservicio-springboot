package com.nttdata.springboot.category.service;


import com.nttdata.springboot.category.client.ProductClient;
import com.nttdata.springboot.category.dao.CategoryDao;
import com.nttdata.springboot.category.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    ProductClient productClient;

    @Autowired
    CategoryDao categoryDao;

    @Override
    public Category getCategory(Integer id) {
        Category category =categoryDao.findById(id).orElse(Category.builder().build());
        category.setListProduct(productClient.getProductCategory(id));
        return category;

      /*  return Category.builder()
                .id(1)
                .description("Category Gold")
                .listProduct(productClient.getProductAll())
                .build();*/
    }

    @Override
    public List<Category> getCategoryAll() {
        List<Category> listCategory = new ArrayList<>();
        categoryDao.findAll().forEach( category -> listCategory.add(category));
        return listCategory;
    }

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryDao.deleteById(id);
    }

    @Override
    public List<Category> getCategoryByPrice(Double price) {
        return categoryDao.getCategoryByPrice(price);
    }

    @Override
    public List<Category> getCategoryByType(String type) {
        return categoryDao.getCategoryByType(type);
    }

    @Override
    public List<CategoryProjection> getCategoryProjectionByType(String type) {
        return categoryDao.getCategoryProjectionByType(type);
    }
}
