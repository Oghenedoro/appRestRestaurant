package com.org.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.org.restaurant.entities.FoodItem;

//@RepositoryRestResource
public interface FoodItemRepository extends JpaRepository<FoodItem, Long>{
	public String findByName(String foodItemName);
	public Integer findByPrix(Integer prix);
}
