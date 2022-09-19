package com.miniproject.quitz;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	Connection connection = null;
	
	public Connection getConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject1", "root", "Admin@123");
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return connection;
	
	}	

}
