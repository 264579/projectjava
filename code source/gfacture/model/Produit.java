/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfacture.model;

/**
 *
 * @author ussf
 */


import java.util.List;

public class Produit {
	
	
	private int id_produit;
	
	private String nom ;
	
	private Double prixu ;
	
	private List<Commande> listcmds ;
	

	public List<Commande> getListcmds() {
		return listcmds;
	}

	public void setListcmds(List<Commande> listcmds) {
		this.listcmds = listcmds;
	}

	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrixu() {
		return prixu;
	}

	public void setPrixu(Double prixu) {
		this.prixu = prixu;
	}

	public Produit(Integer id_produit, String nom, Double prixu) {
		super();
		this.id_produit = id_produit;
		this.nom = nom;
		this.prixu = prixu;
	}
        public Produit( String nom, Double prixu) {
		super();
		this.nom = nom;
		this.prixu = prixu;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

