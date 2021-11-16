package com.nttdata.springboot.category.client;


import com.nttdata.springboot.category.client.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/* sin eureka */
//@FeignClient(name = "service-product",url = "http://localhost:8081")
/* con eureka */
@FeignClient(name = "service-product")
public interface ProductClient {

    @GetMapping("/getProductAll")
    List<Product> getProductAll();
}
