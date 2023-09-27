package com.akemitti.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesMem implements GerenciadorNomes{
	
	private Connection connection;
	
	public GerenciadorNomesMem()throws Exception{
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://drona.db.elephantsql.com/wrptfvid";
		String username = "wrptfvid";
		String password = "8WgeCLi5HJJpSEafknNYWDvuLlHGWkLa";
		this.connection = DriverManager.getConnection(url, username, password);
	}
	
	
	@Override
	public List<String> obterNomes() {
	    List<String> nomes = new ArrayList<>();
	    try {
	        // select
	        String selectQuery = "SELECT nome FROM nomes";
	        
	        PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
	        
	        ResultSet rs = selectStatement.executeQuery();
	        
	        while(rs.next()) {
	            nomes.add(rs.getString("nome"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return nomes;
	}

	@Override
	public void adicionarNome(String nome) {
	    try {
	        // insert
	        String insertQuery = "INSERT INTO nomes (nome) VALUES (?)";
	    
	        PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
	        
	        insertStatement.setString(1, nome);
	        
	        insertStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
