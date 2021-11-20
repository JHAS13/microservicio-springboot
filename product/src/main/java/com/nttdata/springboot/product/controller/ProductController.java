package com.nttdata.springboot.product.controller;


import com.nttdata.springboot.product.configuration.CacheProperties;
import com.nttdata.springboot.product.model.Product;
import com.nttdata.springboot.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("productService")
    ProductService productService;

    /**
     * @Value para obtener datos del properties
     * */
    @Value("${spring.application.name}")
    private String applicationName;


    /**
     * @ConfigurationProperties para obtener datos del properties desde una clase
     * */
    @Autowired
    private CacheProperties cacheProperties;

    @Autowired
    @Qualifier("productoMysqlService")
    ProductService productoMysqlService;

    @GetMapping("/bienvenida")
    public String getBienvenida(){
        return "HOLA MUNDO";
    }


    /**
     * Qualifier para diferenciar implementaciones de una interface
     */

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable Integer id){
        return  productService.getProduct(id);
    }

    @PostMapping("/getProduct")
    public Product getPostProduct(){
        return productoMysqlService.getProduct(1);
    }


    @GetMapping("/getProductAll")
    public List<Product> getProductAll(){
        return  productService.getProductAll();
    }

    @GetMapping("/getProduct/category/{id}")
    public List<Product> getProductCategory(@PathVariable Integer id){
        return  productService.getProductByIdCategory(id);
    }



    /**
     * PathVariable > Datos enviados en la url
     * */
    @GetMapping("/getProducts/{id}")
    public String getProductId(@PathVariable(value = "id") Integer idProducto){
        return idProducto.toString();
    }

    /**
     * RequestParam > Datos enviados en Query Params
     * */
    @GetMapping("/products")
    public String getProductRequestParam(@RequestParam(value = "id",defaultValue = "123") Integer id){
        return id.toString();
    }

    /**
     * RESPONSE ENTITY > para manipular la estructura del http response (status,header,content)
     * */
    @PostMapping("/responseEntity")
    ResponseEntity<Product> responseEntity (){
        return ResponseEntity
                .ok()
                .header("token","1365475")
                .body(productService.getProduct(1));
        //return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * @Valid validar el objeto atravez de anotaciones
     * */
    @PostMapping("/validateProduct")
    ResponseEntity<Product> validateProduct(@Valid @RequestBody  Product producto){
      return ResponseEntity.ok().body(producto);
    }


    /**
     * @RequestHeader -map -> nos permite obtener las cabeceras de la peticion
     * */
    @PostMapping("/listHeader")
    List<String> getListHeader(@RequestHeader Map<String,String> listHeader){
        List<String> listaH = new ArrayList<>();
        listHeader.forEach((key,value) -> listaH.add(value));
        listaH.add(applicationName);
        return listaH;
    }

    /**
     * @RequestHeader decripcion -> nos permite obtener la cabera de la peticion atravez de la descripcion
     *
     * */
    @PostMapping("/jwtHeader")
    String jwtHeader(@RequestHeader("jwt") String jwt){
        return jwt;
    }


    @GetMapping("/getCacheProperties")
    CacheProperties getCacheProperties(){
        return  cacheProperties;
    }








}
