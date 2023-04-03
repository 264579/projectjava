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


import java.util.ArrayList;
import java.util.List;

public class Commande {
	
	
	private Integer id_cmd ;
	
	private String numero ;
	private Integer id_client;
	private List<Ligne_cmd> lsit_ligne_cmd ;
	
	

	public List<Ligne_cmd> getLsitLigneCmd() {
		return lsit_ligne_cmd;
	}

	public void setLsitprods(List<Ligne_cmd> lsit_ligne_cmd) {
		this.lsit_ligne_cmd = lsit_ligne_cmd;
	}

	public Commande() {
		super();
                lsit_ligne_cmd=new ArrayList<Ligne_cmd>();
		// TODO Auto-generated constructor stub
	}

	public Commande(int id_cmd, String numero,int id_client) {
		super();
		this.id_cmd = id_cmd;
		this.numero = numero;
                this.id_client=id_client;
                lsit_ligne_cmd=new ArrayList<Ligne_cmd>();
	}
        public Commande(String numero,int id_client) {
		super();
		this.id_cmd = id_cmd;
		this.numero = numero;
                this.id_client=id_client;
                lsit_ligne_cmd=new ArrayList<Ligne_cmd>();
	}


	public Integer getId_cmd() {
		return id_cmd;
	}

	public void setId_cmd(Integer id_cmd) {
		this.id_cmd = id_cmd;
	}

	public String getNumero() {
		return numero;
	}
        public int getIdClient() {
            return id_client;
        }

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}

