package com.provai.senior.repository;

import com.provai.senior.models.OrderInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderInventoryRepository extends JpaRepository<OrderInventory, UUID> {

}
