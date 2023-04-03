/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfacture.dao;

import gfacture.model.Commande;
import gfacture.model.Ligne_cmd;
import gfacture.model.Produit;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ussf
 */
public class Ligne_cmdDAO extends BaseDAO<Ligne_cmd>{

    public Ligne_cmdDAO() throws SQLException {
        super();
    }
    @Override
    public void save(Ligne_cmd object) throws SQLException {
        String sql="INSERT INTO `lign_cmd`(`qte`, `id_cmd`, `id_produit`) VALUES(?,?,?)";
        this.preparedStatement=this.connection.prepareStatement(sql);
        
        this.preparedStatement.setInt(1, object.getQte());
        this.preparedStatement.setInt(2, object.getCommande().getId_cmd() );
        this.preparedStatement.setInt(3, object.getProduit().getId_produit() );
        
        this.preparedStatement.execute();
    }

    @Override
    public void update(Ligne_cmd object) throws SQLException {
        String sql="UPDATE `lign_cmd` SET `qte`=?,`id_cmd`=?,`id_produit`=? WHERE id_lign_cmd=?";
        this.preparedStatement=this.connection.prepareStatement(sql);

        this.preparedStatement.setInt(1, object.getQte());
        this.preparedStatement.setInt(2, object.getCommande().getId_cmd() );
        this.preparedStatement.setInt(3, object.getProduit().getId_produit() );
        this.preparedStatement.setInt(4, object.getId_ligne_cmd());
        
        this.preparedStatement.execute();
    }

    @Override
    public void delete(Ligne_cmd object) throws SQLException {
        String sql="DELETE FROM `lign_cmd` WHERE id_lign_cmd=?";
        this.preparedStatement=this.connection.prepareStatement(sql);
        
        this.preparedStatement.setInt(1,object.getId_ligne_cmd());
    }

    @Override
    public Ligne_cmd getOne(int id) throws SQLException {
        
        Ligne_cmd lign=new Ligne_cmd();
        
        String sql="SELECT * FROM `lign_cmd` WHERE id_ling_cmd=?";
        this.preparedStatement=this.connection.prepareStatement(sql);
        
        this.preparedStatement.setInt(1, id);
        this.resultset=this.preparedStatement.executeQuery();
        while(this.resultset.next()) {
             lign=new Ligne_cmd(this.resultset.getInt(2));
            
            Produit prd=new ProduitDAO().getOne(this.resultset.getInt(3));
            lign.setProduit(prd);
            
            Commande cmd=new CommandeDAO().getOne(this.resultset.getInt(4));
            lign.setCommande(cmd);
        }
        return lign;
    }

    @Override
    public List<Ligne_cmd> getall() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
