package com.provai.senior.controller;

import com.provai.senior.dto.OrderDto;
import com.provai.senior.models.Client;
import com.provai.senior.models.Order;
import com.provai.senior.services.ClientService;
import com.provai.senior.services.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService service;

    public OrderController(OrderService service){
        this.service = service;
    }

    /**
     *
     * @return a List of orders.
     */
    @GetMapping("/all")
    public List<Order> findAll(){
        return service.findAll();
    }

    /**
     *
     * @param orderDto DTO from order.
     * @return order registered.
     */
    @PostMapping("/add")
    public Order insert(@RequestBody @Valid OrderDto orderDto){
        return service.insert(orderDto);
    }

    /**
     *
     * @param id id from order.
     * @param orderDto order is going to be updated.
     * @return Order updated.
     */
    @PutMapping("/{id}")
    public Order update(@PathVariable UUID id, @RequestBody @Valid OrderDto orderDto){
        return service.update(id, orderDto);
    }

    /**
     *
     * @param id id from order.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
