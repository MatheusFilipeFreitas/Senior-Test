package com.provai.senior.services;

import com.provai.senior.dto.OrderInventoryDto;
import com.provai.senior.mappers.OrderInventoryMapper;
import com.provai.senior.models.Client;
import com.provai.senior.models.Order;
import com.provai.senior.models.OrderInventory;
import com.provai.senior.models.Product;
import com.provai.senior.repository.OrderInventoryRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class OrderInventoryService {

    private final OrderInventoryRepository repository;
    private final ProductService productService;

    public OrderInventoryService(OrderInventoryRepository repository, ProductService productService){
        this.productService = productService;
        this.repository = repository;
    }

    public List<OrderInventory> findAll(){
        return repository.findAll();
    }

    public OrderInventory insert(OrderInventoryDto orderInventoryDto){
        OrderInventory orderInventory = OrderInventoryMapper.mapOrderInventory(orderInventoryDto);
        addProductByID(orderInventory, orderInventoryDto.getProductID());
        valueCalculator(orderInventory, orderInventoryDto.getProductID());
        return repository.save(orderInventory);
    }

    public OrderInventory update(UUID id, OrderInventoryDto orderInventoryDto){
        OrderInventory overrideOrderInventory = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
        overrideOrderInventory.setQuantity(orderInventoryDto.getQuantity());
        addProductByID(overrideOrderInventory, orderInventoryDto.getProductID());
        valueCalculator(overrideOrderInventory, orderInventoryDto.getProductID());
        return repository.save(overrideOrderInventory);
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }

    public OrderInventory findByID(UUID id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found!"));
    }

    public void addProductByID(OrderInventory orderInventory, UUID productID){
        Product product = productService.findByID(productID);
        orderInventory.setProduct(product);
    }

    public void valueCalculator(OrderInventory orderInventory, UUID productID){
        Product product = productService.findByID(productID);
        orderInventory.setValue(Double.valueOf(orderInventory.getQuantity()) * product.getValue());
    }

    /**
     *
     * External Method (Called by: calcValue function In OrderService)
     */
    public Character getProductTypeByProductID(OrderInventory orderInventory){
        Product product = orderInventory.getProduct();
        return product.getType();
    }


}
