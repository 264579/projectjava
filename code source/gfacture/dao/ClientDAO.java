/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfacture.dao;

/**
 *
 * @author ussf
 */


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gfacture.model.Client;

public class ClientDAO extends BaseDAO<Client> {

	public ClientDAO() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Client object) throws SQLException {
		
		String sql = "insert into client (nom, email) values (? ,?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
	// mapping objet relation
		
		this.preparedStatement.setString(1, object.getNom());
		this.preparedStatement.setString(2, object.getEmail());
		
		this.preparedStatement.execute();
	}

	@Override
	public void update(Client object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Client object) throws SQLException {
		String sql="DELETE FROM client WHERE id_client=?";
                this.preparedStatement=this.connection.prepareStatement(sql);
                this.preparedStatement.setInt(1, object.getId_client() );
                this.preparedStatement.execute();
	}

	@Override
	public Client getOne(int id)throws SQLException {
		
		Client cli = new Client();
		String sql = "select * from client where id_client = ?" ;

		this.preparedStatement = connection.prepareStatement(sql) ;
		
		this.preparedStatement.setInt(1, id);
		
	this.resultset =this.preparedStatement.executeQuery();
		
		
	while (this.resultset.next()) {
		
		cli = new Client(this.resultset.getInt(1) ,this.resultset.getString(2),this.resultset.getString(3));
		
		break ;
	}
	
	return cli ;
	}

	@Override
	public List<Client> getall() throws SQLException {
		
		List<Client> list = new ArrayList<Client>() ;
		
		String sql = "select * from client" ;

		this.statement = connection.createStatement();
		
                this.resultset =this.statement.executeQuery(sql);
		
		
	while (this.resultset.next()) {
		
		list.add(new Client(this.resultset.getInt(1) ,this.resultset.getString(2),this.resultset.getString(3)));
	}
		
		return list;
	}

}

