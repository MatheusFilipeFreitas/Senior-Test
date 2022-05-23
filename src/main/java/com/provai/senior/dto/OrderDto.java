package com.provai.senior.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class OrderDto {

    @NotNull
    private LocalDate date;
    @NotNull
    private Character status;
    @NotNull
    private LocalDate term;
    private Double discount;
    @NotNull
    private UUID clientID;
    @NotNull
    private UUID orderInventoryID;
}
