package com.provai.senior.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_order_inventory")
public class OrderInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Integer quantity;
    private Double value;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

}
