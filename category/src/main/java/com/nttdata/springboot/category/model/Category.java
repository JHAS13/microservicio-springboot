package com.nttdata.springboot.category.model;

import com.nttdata.springboot.category.client.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
@AllArgsConstructor
@ToString
@Builder
public class Category {

    private Integer id;
    private String description;
    private List<Product> listProduct;

}
