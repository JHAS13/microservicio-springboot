package com.nttdata.springboot.product.service;

import com.nttdata.springboot.product.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("productService")
public class ProductServiceImpl implements  ProductService{

    @Override
    public Product getProduct() {
        return Product.builder()
                .id(1)
                .name("producto 1")
                .build();
    }

    public List<Product> getProductAll(){
        List<Product> listProduct = new ArrayList<>();
        listProduct.add(Product.builder().id(1).name("producto 1").build());
        listProduct.add(Product.builder().id(2).name("producto 2").build());
        listProduct.add(Product.builder().id(3).name("producto 3").build());
        listProduct.add(Product.builder().id(4).name("producto 4").build());
        listProduct.add(Product.builder().id(5).name("producto 5").build());

        return listProduct;
    }
}
