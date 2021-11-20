package com.nttdata.springboot.category.model;

import com.nttdata.springboot.category.client.model.Product;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "category")
@NamedQuery(name = "Category.getCategoryByType",query = "from Category c where c.type= :type")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    private String type;

    private Double price;

    @Transient
    private List<Product> listProduct;

}
