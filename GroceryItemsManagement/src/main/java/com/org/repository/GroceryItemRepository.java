package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entity.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {

}
