package com.nttdata.springboot.category.dao;

import com.nttdata.springboot.category.model.Category;
import com.nttdata.springboot.category.service.CategoryProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryDao extends CrudRepository<Category,Integer> {

    @Query("select c from Category c where c.price= :price")
    List<Category> getCategoryByPrice(Double price);


    List<Category> getCategoryByType(String type);

    List<CategoryProjection> getCategoryProjectionByType(String type);

}
