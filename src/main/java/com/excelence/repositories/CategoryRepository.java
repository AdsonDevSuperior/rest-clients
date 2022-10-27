package com.excelence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelence.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
