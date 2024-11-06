package com.swetank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swetank.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{

}
