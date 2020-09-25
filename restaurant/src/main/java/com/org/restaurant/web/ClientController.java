package com.org.restaurant.web;

import java.util.Collection;

import org.springframework.web.bind.annotation.*;

import com.org.restaurant.entities.Client;
import com.org.restaurant.repositories.ClientRepository;

@CrossOrigin("*")
@RestController
public class ClientController {

	private ClientRepository clientRepository;

	public ClientController(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}
	
	@GetMapping("/clients")
	public Collection<Client> getAllClients(){
		
		return clientRepository.findAll();
	}

	@PostMapping("/clients")
	public Client registerClient(@RequestBody Client client)	{
		return clientRepository.save(client);
	}
}
