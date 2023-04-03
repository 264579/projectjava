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

public class Client {
	
	
	
	private Integer id_client ;
	
	private String nom ;
	
	private String email ;
	
	private List<Commande> listcmds ;
	
	public Client(int id_client, String nom, String email) {
		super();
		this.id_client = id_client;
		this.nom = nom;
		this.email = email;
	}
        public Client( String nom, String email) {
		super();
		
		this.nom = nom;
		this.email = email;
	}


	public Client() {
		super();
		
	}
	
	

	public List<Commande> getListcmds() {
		return listcmds;
	}

	public void setListcmds(List<Commande> listcmds) {
		this.listcmds = listcmds;
	}

	

	// gets and sets 
	public Integer getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	

}

