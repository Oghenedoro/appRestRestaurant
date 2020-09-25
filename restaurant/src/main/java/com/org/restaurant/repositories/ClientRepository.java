package com.org.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.org.restaurant.entities.Client;


//@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long>{

}
