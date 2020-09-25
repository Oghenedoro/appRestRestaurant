package com.org.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.org.restaurant.entities.Commande;


//@RepositoryRestResource
public interface CommandRepository extends JpaRepository<Commande, Long>{
	public Commande findByRefCommande(Integer ref);

}
