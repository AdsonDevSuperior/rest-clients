package com.excelence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelence.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
