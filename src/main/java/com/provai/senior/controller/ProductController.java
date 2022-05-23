package com.provai.senior.controller;

import com.provai.senior.dto.ProductDto;
import com.provai.senior.models.Client;
import com.provai.senior.models.Product;
import com.provai.senior.services.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    /**
     *
     * @return a List of products.
     */
    @GetMapping("/all")
    public List<Product> findAll(){
        return service.findAll();
    }

    /**
     *
     * @param productDto DTO from product.
     * @return Client registered.
     */
    @PostMapping("/add")
    public Product insert(@RequestBody @Valid ProductDto productDto){
        return service.insert(productDto);
    }

    /**
     *
     * @param id id from product.
     * @param product product is going to be updated.
     * @return Product updated.
     */
    @PutMapping("/{id}")
    public Product update(@PathVariable UUID id, @RequestBody @Valid ProductDto productDto){
        return service.update(id, productDto);
    }

    /**
     *
     * @param id id from product.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
