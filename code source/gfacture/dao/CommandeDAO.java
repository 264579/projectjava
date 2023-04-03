/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfacture.dao;

import java.sql.SQLException;
import java.util.List;
import gfacture.model.Commande;
import gfacture.model.Ligne_cmd;
import gfacture.model.Produit;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author ussf
 */
public class CommandeDAO extends BaseDAO<Commande> {
    public CommandeDAO() throws SQLException {
        super();
    }
    @Override
    public  void save (Commande object) throws SQLException {
        
        //ajoute dans table command 
        String sql="INSERT INTO `cmd`( `id_cmd`, `numero`, `id_client`) VALUES (?,?,?)";
        this.preparedStatement=this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, object.getId_cmd());
        this.preparedStatement.setString(2, object.getNumero());
        this.preparedStatement.setInt(3,object.getIdClient());
        
        this.preparedStatement.execute();
        
        //remplir ligne des commandes 
        
        sql="INSERT INTO `lign_cmd`(`qte`, `id_cmd`, `id_produit`) VALUES (?,?,?)";
        this.preparedStatement=this.connection.prepareStatement(sql);
        
        Ligne_cmd ligne;
        Iterator<Ligne_cmd> it=object.getLsitLigneCmd().iterator();
        while(it.hasNext()) {
            ligne=it.next();
            this.preparedStatement.setInt(1,ligne.getQte());
            this.preparedStatement.setInt(2,ligne.getCommande().getId_cmd());
            this.preparedStatement.setInt(3,ligne.getProduit().getId_produit());
            this.preparedStatement.execute();
        }
        
    }

    /**
     *
     * @param object
     * @throws SQLException
     */
    @Override
	public  void update (Commande object) throws SQLException  {
            
            String sql="UPDATE `cmd` SET `numero`=?,`id_client`=? WHERE id_cmd=?";
            
            this.preparedStatement=this.connection.prepareStatement(sql);
            
            this.preparedStatement.setString(1, object.getNumero());
            this.preparedStatement.setInt(2,object.getIdClient());
            this.preparedStatement.setInt(3, object.getId_cmd());
            
            this.preparedStatement.execute();
            
            sql="UPDATE `lign_cmd` SET `qte`=?,`id_cmd`=?,`id_produit`=? WHERE id_lign_cmd=?";
            this.preparedStatement=this.connection.prepareStatement(sql);
            
            Ligne_cmd ligne;
            Iterator<Ligne_cmd> it=object.getLsitLigneCmd().iterator();
            
            while(it.hasNext()) {
                
                ligne=it.next();
                this.preparedStatement.setInt(1,ligne.getQte());
                this.preparedStatement.setInt(2,ligne.getCommande().getId_cmd());
                this.preparedStatement.setInt(3,ligne.getProduit().getId_produit());
                this.preparedStatement.setInt(4,ligne.getId_ligne_cmd());
                this.preparedStatement.execute();
            }

        }
        
    @Override
	public void delete (Commande object) throws SQLException  {
            
            String sql="delete from lign_cmd where id_lign_cmd=?";
            this.preparedStatement=this.connection.prepareStatement(sql);
            Iterator<Ligne_cmd> it=object.getLsitLigneCmd().iterator();
            Ligne_cmd ligne;
            while(it.hasNext()) {
                ligne=it.next();
                this.preparedStatement.setInt(1,ligne.getId_ligne_cmd());
                this.preparedStatement.execute();
            }
            
            sql="delete from cmd where id_cmd=?";
            this.preparedStatement=this.connection.prepareStatement(sql);
            this.preparedStatement.setInt(1,object.getId_cmd());
            this.preparedStatement.execute();
        }
	
    @Override
	public  Commande getOne (int id)  throws SQLException {
            //select commande correspondant
            Commande cmd=new Commande();
            String sql="SELECT * FROM `cmd` WHERE id_cmd=?";
            this.preparedStatement=this.connection.prepareStatement(sql);
            this.preparedStatement.setInt(1,id);
            this.resultset=this.preparedStatement.executeQuery();
            while(this.resultset.next()) {
                cmd=new Commande(this.resultset.getInt(1),this.resultset.getString(2),this.resultset.getInt(3));
                break;
            }
            //select tous les lign de commande 
            sql="SELECT * FROM `lign_cmd` WHERE id_cmd=?";
            this.preparedStatement=this.connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, id);
            this.resultset=this.preparedStatement.executeQuery();
            
            // pour chaque ligne select produit correspondant
            ArrayList<Ligne_cmd> ligns=new ArrayList<Ligne_cmd>() ;
            Produit prd;
            int id_prd,index=-1;
            ResultSet resultset_prd ;
            
            while(this.resultset.next()) {
                 index++;
                 ligns.add( new Ligne_cmd( this.resultset.getInt(1) ) );
                 id_prd=this.resultset.getInt(3);
                  //get produit 
                  sql="SELECT * FROM `produit` WHERE id_produit=?";
                  this.preparedStatement=this.connection.prepareStatement(sql);
                  this.preparedStatement.setInt(1,id_prd);
                  resultset_prd=this.preparedStatement.executeQuery();
                   
                   while(resultset_prd.next()) {
                       prd=new Produit(resultset_prd.getInt(1),resultset_prd.getString(2),resultset_prd.getDouble(3));
                       ligns.get(index).setProduit(prd);
                       break;
                   }
            }
            
            cmd.setLsitprods(ligns);
            
            return cmd;
        }
	
    @Override
	public  List<Commande> getall () throws SQLException  {
            List commands=new ArrayList<Commande>();
            Commande cmd;
            String sql="SELECT * FROM `cmd` WHERE 1";
            this.preparedStatement=this.connection.prepareStatement(sql);
            this.resultset=this.preparedStatement.executeQuery();
            
            while(this.resultset.next()) {
                cmd=new Commande(this.resultset.getInt(1),this.resultset.getString(2),this.resultset.getInt(3));
                
                sql="SELECT * FROM `lign_cmd` WHERE id_cmd=?";
                this.preparedStatement=this.connection.prepareStatement(sql);
                this.preparedStatement.setInt(1, cmd.getId_cmd());
                ResultSet result_lign_cmd =this.preparedStatement.executeQuery();
                
                ArrayList<Ligne_cmd> ligns=new ArrayList<Ligne_cmd>() ;
                Produit prd;
                int id_prd,index=-1;
                ResultSet resultset_prd ;
                
                while(result_lign_cmd.next()) {
                    index++;
                    ligns.add( new Ligne_cmd( result_lign_cmd.getInt(1),result_lign_cmd.getInt(2) ) );
                    id_prd=result_lign_cmd.getInt(4);
                    //get produit 
                    prd=(new ProduitDAO()).getOne(id_prd);
                    ligns.get(index).setProduit(prd);
                    ligns.get(index).setCommande(cmd);
                    
                }
                cmd.setLsitprods(ligns);
                commands.add(cmd);
            }
            return commands;
        }





}
