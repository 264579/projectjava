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


public class Ligne_cmd {
	
	private int id_ligne_cmd;
	private int qte ;
	
	private Produit produit ;
	
	private Commande commande ;
	
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Integer getId_ligne_cmd() {
		return id_ligne_cmd;
	}
	public void setId_ligne_cmd(Integer id_ligne_cmd) {
		this.id_ligne_cmd = id_ligne_cmd;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public Ligne_cmd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ligne_cmd(int qte) {
		super();
		this.qte = qte;
	}
        public Ligne_cmd(int id,int qte) {
		super();
                this.id_ligne_cmd=id;
		this.qte = qte;
	}
	
	

}

