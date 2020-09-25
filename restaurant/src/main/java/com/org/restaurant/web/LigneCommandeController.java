package com.org.restaurant.web;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.org.restaurant.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.restaurant.entities.Client;
import com.org.restaurant.entities.Commande;
import com.org.restaurant.entities.FoodItem;
import com.org.restaurant.entities.LigneCommande;
import com.org.restaurant.repositories.CommandRepository;
import com.org.restaurant.repositories.FoodItemRepository;
import com.org.restaurant.repositories.LigneCommandRepository;

@CrossOrigin("*")
@RestController
public class LigneCommandeController {
	
	private LigneCommandRepository ligneCommandRepository;
	private FoodItemRepository foodItemRepository;
	private CommandRepository commandRepository;
	private ClientRepository clientRepository;

	public LigneCommandeController(LigneCommandRepository ligneCommandRepository,
		FoodItemRepository foodItemRepository,CommandRepository commandRepository,
								   ClientRepository clientRepository) {

		this.ligneCommandRepository = ligneCommandRepository;
		this.foodItemRepository = foodItemRepository;
		this.commandRepository = commandRepository;
		this.clientRepository = clientRepository;
	}

	@PostMapping("/lignecommands")
	public LigneCommande createOrderItem(@RequestBody LigneCommande ligneCommande)	{

		Random rand = new Random();
		Commande commande = new Commande();
		Client client = clientRepository.findById(3l).get();
			
    	commande.setDate(new Date());
		commande.setRefCommande(100*rand.nextInt(1000));
		commande.setPayMethod(ligneCommande.getCommande().getPayMethod());
		commande.setIdClient(client.getIdClient());
		commandRepository.save(commande);

		ligneCommande.setCommande(commande);
		ligneCommande.setRefCommande(commande.getRefCommande());
		ligneCommande.setTotal(ligneCommande.getPrix()*ligneCommande.getQuantity());

		return ligneCommandRepository.save(ligneCommande);
		

	}
	
	
	@GetMapping("/lignecommands")
	public Collection<LigneCommande> getLigneCommands(){
		return ligneCommandRepository.findAll();
		
	}
	
	
	
//private Map<Long, LigneCommande> items = new HashMap<>();
//	
//	public void addProductsToPanier(int quantity, FoodItem foodItem){
//		
//		if(foodItem.getIdfoodItem() == null){
//			LigneCommande ligneCommande = new LigneCommande();
//			ligneCommande.setProduit(foodItem);
//			ligneCommande.setPrix(foodItem.getPrix());
//			ligneCommande.setQuantity(quantity); 
//		}
//		else{
//			LigneCommande ligneCommande = items.get(foodItem.getIdfoodItem());
//			ligneCommande.setQuantity(ligneCommande.getQuantity()+quantity);
//		}
//		

}

