package com.excelence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelence.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
