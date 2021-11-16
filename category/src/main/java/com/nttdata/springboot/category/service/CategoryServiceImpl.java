package com.nttdata.springboot.category.service;


import com.nttdata.springboot.category.client.ProductClient;
import com.nttdata.springboot.category.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    ProductClient productClient;

    @Override
    public Category getCategory() {
        return Category.builder()
                .id(1)
                .description("Category Gold")
                .listProduct(productClient.getProductAll())
                .build();
    }
}
