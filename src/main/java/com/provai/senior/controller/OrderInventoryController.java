package com.provai.senior.controller;

import com.provai.senior.dto.OrderInventoryDto;
import com.provai.senior.models.Order;
import com.provai.senior.models.OrderInventory;
import com.provai.senior.services.OrderInventoryService;
import com.provai.senior.services.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/inventory")
public class OrderInventoryController {


    private OrderInventoryService service;

    public OrderInventoryController(OrderInventoryService service){
        this.service = service;
    }

    /**
     *
     * @return a List of invetory.
     */
    @GetMapping("/all")
    public List<OrderInventory> findAll(){
        return service.findAll();
    }

    /**
     *
     * @param orderInventoryDto DTO from invetory.
     * @return invetory registered.
     */
    @PostMapping("/add")
    public OrderInventory insert(@RequestBody @Valid OrderInventoryDto orderInventoryDto){
        return service.insert(orderInventoryDto);
    }

    /**
     *
     * @param id id from invetory.
     * @param orderInventoryDto invetory is going to be updated.
     * @return invetory updated.
     */
    @PutMapping("/{id}")
    public OrderInventory update(@PathVariable UUID id, @RequestBody @Valid OrderInventoryDto orderInventoryDto){
        return service.update(id, orderInventoryDto);
    }

    /**
     *
     * @param id id from invetory.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
