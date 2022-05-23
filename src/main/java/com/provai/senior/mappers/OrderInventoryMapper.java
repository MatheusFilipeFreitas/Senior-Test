package com.provai.senior.mappers;

import com.provai.senior.dto.OrderInventoryDto;
import com.provai.senior.models.OrderInventory;

public class OrderInventoryMapper {

    public static OrderInventory mapOrderInventory(OrderInventoryDto orderInventoryDto){
        OrderInventory orderInventory = new OrderInventory();
        orderInventory.setQuantity(orderInventoryDto.getQuantity());
        return orderInventory;
    }
}
