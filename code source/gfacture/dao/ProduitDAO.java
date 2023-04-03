/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfacture.dao;

import gfacture.model.Produit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ussf
 */
public class ProduitDAO extends BaseDAO<Produit>{

    public ProduitDAO() throws SQLException {
        super();
    }
    @Override
    public void save(Produit object) throws SQLException {
        String sql="INSERT INTO `produit`(`nom`, `pu`) VALUES (?,?)";
        this.preparedStatement=this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, object.getNom());
        this.preparedStatement.setDouble(2, object.getPrixu());
        this.preparedStatement.execute();
        
    }

    @Override
    public void update(Produit object) throws SQLException {
        String sql="UPDATE `produit` SET `nom`=?,`pu`=? WHERE id_produit=?";
        this.preparedStatement=this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, object.getNom());
        this.preparedStatement.setDouble(2, object.getPrixu());
        this.preparedStatement.execute();
    }

    @Override
    public void delete(Produit object) throws SQLException {
        String sql="DELETE FROM `produit` WHERE id_produit=?";
        this.preparedStatement=this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, object.getId_produit());
        this.preparedStatement.execute();
    }

    @Override
    public Produit getOne(int id) throws SQLException {
        Produit prd=new Produit();
        String sql="SELECT * FROM `produit` WHERE id_produit=?";
        this.preparedStatement=this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, id);
        this.resultset=this.preparedStatement.executeQuery();
        while(this.resultset.next()) {
            prd=new Produit(this.resultset.getInt(1),this.resultset.getString(2),this.resultset.getDouble(3));
            break;
        }
        return prd;
    }

    @Override
    public List<Produit> getall() throws SQLException {
        List<Produit> produits=new ArrayList<Produit>();
        
        String sql="SELECT * FROM `produit` WHERE 1";
        this.preparedStatement=this.connection.prepareStatement(sql);
        this.resultset=this.preparedStatement.executeQuery();
        while(this.resultset.next()) {
            produits.add( new Produit(this.resultset.getInt(1),this.resultset.getString(2),this.resultset.getDouble(3) ) );
        }
        return produits;
    }
    
}
