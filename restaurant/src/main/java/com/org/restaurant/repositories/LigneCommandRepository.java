package com.org.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.org.restaurant.entities.LigneCommande;

//@RepositoryRestResource
public interface LigneCommandRepository extends JpaRepository<LigneCommande, Long>{

}
