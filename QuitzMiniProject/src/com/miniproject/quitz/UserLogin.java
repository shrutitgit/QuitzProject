package com.miniproject.quitz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserLogin {

	
	public static void checkUser() throws SQLException 
	{
		Scanner sc = new Scanner(System.in);
		String dbUserName = "";
		String dbPass = "";
		System.out.println("\n");
//		System.out.println("-------***-WELCOME FOR LOGIN-***-------");
		System.out.println("-------------------------------------");
		System.out.println("Enter Your User Name :");
		String name = sc.next();
		
		System.out.println("Enter your Password :");
		String password = sc.next();
		DatabaseConnection dbcon = new DatabaseConnection();
		Connection con1=dbcon.getConnection();
		Statement stmt = con1.createStatement();
		String sql = "SELECT * from userdetail where userName ='"+name+"' && passKey='"+password+"'";

		ResultSet rs = stmt.executeQuery(sql);

		while(rs.next()) {
			dbUserName = rs.getString("userName");
			dbPass = rs.getString("passKey");
		}
		
		if (name.equals(dbUserName) && password.equals(dbPass)) {
	        System.out.println("Successful Login!\n----");
	        Test.innerMenu();
	    } else {
	        System.out.println("Incorrect Password\n----");
	    }
		
		
	}

	
}
