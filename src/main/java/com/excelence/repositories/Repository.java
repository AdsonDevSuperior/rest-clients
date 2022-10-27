package com.excelence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelence.entities.User;

public interface Repository extends JpaRepository<User, Long>{

}
