package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository <CategoryEntity, Long> {

}
