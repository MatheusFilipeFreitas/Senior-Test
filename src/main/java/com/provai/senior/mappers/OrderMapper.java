package com.provai.senior.mappers;

import com.provai.senior.dto.OrderDto;
import com.provai.senior.models.Order;

public class OrderMapper {

    public static Order mapOrder(OrderDto orderDto){
        Order order = new Order();
        order.setDate(orderDto.getDate());
        order.setStatus(orderDto.getStatus());
        order.setTerm(orderDto.getTerm());
        order.setDiscount(orderDto.getDiscount());
        return order;
    }
}
