package com.nttdata.springboot.product.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull(message = "Id no puede ser nulo")
    private Integer id;

    @Column(name = "name")
    @NotBlank(message = "name no puede estar vacia")
    private String name;

    @Column(name = "id_category")
    private Integer idCategory;
}
