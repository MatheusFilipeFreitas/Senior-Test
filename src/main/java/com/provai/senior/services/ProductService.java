package com.provai.senior.services;

import com.provai.senior.dto.ProductDto;
import com.provai.senior.mappers.ProductMapper;
import com.provai.senior.models.Client;
import com.provai.senior.models.Product;
import com.provai.senior.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product insert(ProductDto productDto){
        Product product = ProductMapper.mapProduct(productDto);
        if(product.getType() != 'p' && product.getType() != 's'){
            //Error: Message type!
            product.setType(null);
        }
        return repository.save(product);
    }

    public Product update(UUID id, ProductDto productDto){
        Product overrideProduct = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
        overrideProduct.setName(productDto.getName());
        overrideProduct.setDescription(productDto.getDescription());
        overrideProduct.setValue(productDto.getValue());
        if(overrideProduct.getType() == 'p' || overrideProduct.getType() == 's') {
            overrideProduct.setType(productDto.getType());
        }
        return repository.save(overrideProduct);
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }

    public Product findByID(UUID id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found!"));
    }


}
