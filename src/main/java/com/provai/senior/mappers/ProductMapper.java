package com.provai.senior.mappers;

import com.provai.senior.dto.ProductDto;
import com.provai.senior.models.Product;

public class ProductMapper {

    public static Product mapProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setType(productDto.getType());
        product.setValue(productDto.getValue());
        return product;
    }
}
