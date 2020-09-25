//package com.org.entities;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Panier {
//
//	private Map<Long, LigneCommande> items = new HashMap<>();
//	
//	public void addProductsToPanier(int quantity, FoodItem foodItem){
//		
//		if(foodItem.getIdProduit() == null){
//			LigneCommande ligneCommande = new LigneCommande();
//			ligneCommande.setProduit(foodItem);
//			ligneCommande.setPrix(foodItem.getPrix());
//			ligneCommande.setQuantity(quantity); 
//		}
//		else{
//			LigneCommande ligneCommande = items.get(foodItem.getIdProduit());
//			ligneCommande.setQuantity(ligneCommande.getQuantity()+quantity);
//		}
//		
//	}
//	public Collection <LigneCommande>getItems(){
//		return items.values();
//		
//	}
//	
//	public Double getTotalPrice(){
//		
//		Double totalPrice = 0.0;
//		for(LigneCommande lc : items.values()){
//			totalPrice += lc.getPrix() * lc.getQuantity();
//			
//		}
//		return totalPrice;
//		
//	}
//	
//	public int getSize(){
//		
//		return items.size();
//	}
//
//	public void deletItem(Long idPrduct){
//		items.remove(idPrduct);
//	}
//}
