package com.org.restaurant.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor 
@Entity 
public class LigneCommande implements Serializable{ 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLigneCommande;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="commandId")
	private Commande commande;

	private Integer refCommande;
	private Integer prix;
	private String itemName;
	private Integer quantity;
	private Integer total;
}
