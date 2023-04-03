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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;



public abstract class BaseDAO <T>   {
	
	
	protected Connection connection ;
	
	protected Statement statement ;
	
	protected PreparedStatement preparedStatement ;
	
	
	protected ResultSet resultset ;
	
	private String url = "jdbc:mysql://localhost:3306/gfacture";
	private String user = "root";
	
	private String password = "";
	
	
	public BaseDAO() throws SQLException {
		
		this.connection  = DriverManager.getConnection(url, user, password);
	}
	
	
	public abstract void save (T object) throws SQLException  ;
	public abstract void update (T object) throws SQLException  ;
	public abstract void delete (T object) throws SQLException  ;
	
	public abstract T getOne (int id)  throws SQLException ;
	
	public abstract List<T> getall () throws SQLException  ;
	
	

}
