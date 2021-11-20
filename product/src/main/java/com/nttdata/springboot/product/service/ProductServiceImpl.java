package com.nttdata.springboot.product.service;

import com.nttdata.springboot.product.dao.ProductDao;
import com.nttdata.springboot.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("productService")
public class ProductServiceImpl implements  ProductService{

    @Autowired
    ProductDao productDao;

    @Override
    public Product getProduct(Integer id) {
        return Product.builder()
                .id(1)
                .name("producto 1")
                .build();
    }

    @Override
    public List<Product> getProductByIdCategory(Integer idCategory) {
        List<Product> listProduct = new ArrayList<>();
        productDao.findProductByIdCategory(idCategory).forEach(product -> listProduct.add(product));
        return listProduct;
    }

    @Override
    public List<Product> getProductAll(){
        List<Product> listProd = new ArrayList<>();
        productDao.findAll().forEach(product -> listProd.add(product));
        return listProd;
    }
}
