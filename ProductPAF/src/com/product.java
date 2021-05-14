package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class product {
	
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/strmgt?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public String insertProduct(String proCode, String desc, String qty, String price, String category)  
	{   
		String output = ""; 
	 
		try   
		{    
			Connection con = connect(); 
	 
			if (con == null)    
			{return "Error while connecting to the database for inserting."; } 
	 
			// create a prepared statement 
			String query = " insert into product(`pro_ID`,`proCode`,`desc`,`qty`,`price`,`category`)"
					 + " values (?, ?, ?, ?, ?, ?)";
	 
	 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
			// binding values    
			 preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, proCode);
			 preparedStmt.setString(3, desc);
			 preparedStmt.setString(4, qty);
			 preparedStmt.setString(5, price);
			 preparedStmt.setString(6, category);
			
			// execute the statement    
			preparedStmt.execute();    
			con.close(); 
	   
			String newProduct = readProduct(); 
			output =  "{\"status\":\"success\", \"data\": \"" + newProduct + "\"}";    
		}   
		catch (Exception e)   
		{    
			output =  "{\"status\":\"error\", \"data\": \"Error while inserting the product.\"}";  
			System.err.println(e.getMessage());   
		} 
		
	  return output;  
	} 