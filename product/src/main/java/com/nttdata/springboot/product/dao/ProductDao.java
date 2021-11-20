package com.nttdata.springboot.product.dao;

import com.nttdata.springboot.product.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductDao extends CrudRepository<Product,Integer> {

    List<Product> findProductByIdCategory(Integer idCategory);
}
