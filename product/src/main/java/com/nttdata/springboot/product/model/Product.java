package com.nttdata.springboot.product.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Builder
public class Product {

    @NotNull(message = "Id no puede ser nulo")
    private Integer id;
    @NotBlank(message = "name no puede estar vacia")
    private String name;
}
