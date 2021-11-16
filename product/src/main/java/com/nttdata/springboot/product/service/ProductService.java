package com.nttdata.springboot.product.service;


import com.nttdata.springboot.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
     Product getProduct();
     List<Product> getProductAll();

}
