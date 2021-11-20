package com.nttdata.springboot.product.service;


import com.nttdata.springboot.product.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("productoMysqlService")
public class ProductMysqlServiceImpl implements  ProductService {

    @Override
    public Product getProduct(Integer id) {
        return Product.builder().id(2).name("PRODUCTO 02").build();
    }

    @Override
    public List<Product> getProductAll() {
        return null;
    }

    @Override
    public List<Product> getProductByIdCategory(Integer idCategory) {
        return null;
    }
}
