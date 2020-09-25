package com.org.restaurant.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import org.assertj.core.util.Arrays;
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
import com.org.restaurant.repositories.ClientRepository;
import com.org.restaurant.repositories.CommandRepository;
import com.org.restaurant.repositories.FoodItemRepository;
import com.org.restaurant.repositories.LigneCommandRepository;

//@CrossOrigin("*")
@RestController
public class CommandController {

	private CommandRepository commandRepository;
	private LigneCommandRepository ligneCommandRepository;
	private ClientRepository clientRepository;
	private FoodItemRepository foodItemRepository;



    public CommandController(CommandRepository commandRepository, LigneCommandRepository ligneCommandRepository,
			ClientRepository clientRepository, FoodItemRepository foodItemRepository) {
		super();
		this.commandRepository = commandRepository;
		this.ligneCommandRepository = ligneCommandRepository;
		this.clientRepository = clientRepository;
		this.foodItemRepository = foodItemRepository;
	}
	@PostMapping("/commandes")
	public Commande registerCommande(@RequestBody Commande commande) {

		Client client = clientRepository.findById(1L).get();
		Random rand = new Random();

		commande.setRefCommande(100 * rand.nextInt(1000));
		commande.setDate(new Date());
		commande.setIdClient(client.getIdClient());
		commande.setPayMethod(commande.getPayMethod());


		Collection<LigneCommande> lc = new ArrayList<>();

		for (LigneCommande ligneCommande : commande.getArticles()) {
			ligneCommande.setCommande(commande);
			ligneCommande.setTotal(ligneCommande.getPrix()*ligneCommande.getQuantity());
			ligneCommande.setRefCommande(commande.getRefCommande());
			lc.add(ligneCommande);

		}
		commande.setArticles(lc);
		return commandRepository.save(commande);

    }

    @GetMapping("/commandes")
    public Collection<Commande> getCommands(){
		return commandRepository.findAll();

    }


}
