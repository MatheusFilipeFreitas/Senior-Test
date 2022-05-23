package com.provai.senior.services;

import com.provai.senior.dto.OrderDto;
import com.provai.senior.mappers.OrderMapper;
import com.provai.senior.models.Client;
import com.provai.senior.models.Order;
import com.provai.senior.models.OrderInventory;
import com.provai.senior.models.Product;
import com.provai.senior.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private OrderRepository repository;
    private ClientService clientService;
    private OrderInventoryService orderInventoryService;

    public OrderService(OrderRepository repository, ClientService clientService, OrderInventoryService orderInventoryService){
        this.orderInventoryService = orderInventoryService;
        this.clientService = clientService;
        this.repository = repository;
    }

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order insert(OrderDto orderDto){
        Order order = OrderMapper.mapOrder(orderDto);
        addClientByID(order, orderDto.getClientID());
        addOrderInventoryByID(order, orderDto.getOrderInventoryID());
        calcQuantity(order, orderDto.getOrderInventoryID());
        calcValue(order, orderDto.getOrderInventoryID());
        return repository.save(order);
    }

    public Order update(UUID id, OrderDto orderDto){
        Order overrideOrder = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
        overrideOrder.setDate(orderDto.getDate());
        overrideOrder.setStatus(orderDto.getStatus());
        overrideOrder.setTerm(orderDto.getTerm());
        overrideOrder.setDiscount(orderDto.getDiscount());
        addClientByID(overrideOrder, orderDto.getClientID());
        addOrderInventoryByID(overrideOrder, orderDto.getOrderInventoryID());
        calcQuantity(overrideOrder, orderDto.getOrderInventoryID());
        calcValue(overrideOrder, orderDto.getOrderInventoryID());
        return repository.save(overrideOrder);
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }

    public void addOrderInventoryByID(Order order, UUID orderInventoryID){
        OrderInventory orderInventory = orderInventoryService.findByID(orderInventoryID);
        order.setOrderInventory(orderInventory);
    }

    public void addClientByID(Order order, UUID clientID){
        Client client = clientService.findByID(clientID);
        order.setClient(client);
    }

    public void calcQuantity(Order order, UUID orderInventoryID){
        OrderInventory orderInventory = orderInventoryService.findByID(orderInventoryID);
        order.setQuantity(orderInventory.getQuantity());
    }

    public void calcValue(Order order, UUID orderInventoryID){
        OrderInventory orderInventory = orderInventoryService.findByID(orderInventoryID);
        Character productType = orderInventoryService.getProductTypeByProductID(orderInventory);
        if(order.getDiscount() != null && order.getDiscount() > 0 && productType == 'p'){
            order.setValue(orderInventory.getValue() - (orderInventory.getValue() * (order.getDiscount()/100)));
        }else{
            order.setDiscount(order.getDiscount() * 0);
            order.setValue(orderInventory.getValue());
        }
    }

}
