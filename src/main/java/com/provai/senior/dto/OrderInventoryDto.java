package com.provai.senior.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class OrderInventoryDto {

    @NotNull
    private Integer quantity;
    @NotNull
    private UUID productID;
}
