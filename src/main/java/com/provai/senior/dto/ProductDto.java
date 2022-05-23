package com.provai.senior.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductDto {

    @NotBlank
    private String name;
    private String description;
    @NotNull
    private Double value;
    @NotNull
    private Character type;
}
