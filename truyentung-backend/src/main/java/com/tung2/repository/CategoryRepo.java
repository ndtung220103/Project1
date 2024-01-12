package com.tung2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tung2.entity.CategoryEntity;

public interface CategoryRepo extends JpaRepository<CategoryEntity,String> {

}
