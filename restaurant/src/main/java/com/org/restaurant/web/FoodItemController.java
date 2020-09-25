package com.org.restaurant.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.restaurant.entities.FoodItem;
import com.org.restaurant.repositories.FoodItemRepository;
import com.org.restaurant.repositories.LigneCommandRepository;

@CrossOrigin("*")
@RestController
public class FoodItemController {
	
	private FoodItemRepository foodItemRepository;
	private LigneCommandRepository ligneCommandRepository;
	
	
	public FoodItemController(FoodItemRepository foodItemRepository) {
		super();
		this.foodItemRepository = foodItemRepository;
		this.ligneCommandRepository = ligneCommandRepository;
		
	}

    @GetMapping("/foodItems")
	public Collection<FoodItem> getFoodItemList(){
		return foodItemRepository.findAll();
		
	}
    
    @PostMapping("/foodItems")
    public FoodItem addFoodItem(@RequestBody FoodItem item){
    	return foodItemRepository.save(item);
    }

    @GetMapping("/foodItems/{id}")
    public FoodItem getById(@PathVariable("id") Long id){
    	
    	return foodItemRepository.findById(id).get();  	  	  	 
    }
    
//    @PostMapping("/foodItems/{quantity}/quantity")
//    public void addProductsToPanier(@PathVariable("quantity")int quantity, @RequestBody FoodItem produit){
//		
//    	 Map<Long, LigneCommande> items = new HashMap<>();
//    	
//		if(produit.getIdProduit() == null){
//			LigneCommande ligneCommande = new LigneCommande();
//			ligneCommande.setProduit(produit);
//			ligneCommande.setPrix(produit.getPrix());
//			ligneCommande.setQuantity(quantity); 
//			
//		}
//		else{
//			LigneCommande ligneCommande = items.get(produit.getIdProduit());
//			ligneCommande.setQuantity(ligneCommande.getQuantity()+quantity);
//		}		
//	}
    
    
}
