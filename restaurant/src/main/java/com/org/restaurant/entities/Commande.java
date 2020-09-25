package com.org.restaurant.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

//@JsonIgnoreProperties({ "articles","client" })
@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Commande implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCommand;
	private Integer refCommande;
	private Long idClient;
	private java.util.Date date;
	private String payMethod;


	@OneToMany(mappedBy = "commande", cascade=CascadeType.ALL)
	//@JoinColumn(name="commandId")
	private Collection<LigneCommande>articles = new ArrayList<>();

}
