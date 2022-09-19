package com.miniproject.quitz;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class UserDetail {

	 Connection con=null;
	 
	 public void userData(String firstName, String middleName,String lastName,String city,String state,
			 int age)
	 {
		 
				
				try
				{
					 DatabaseConnection data=new DatabaseConnection();
			  con=data.getConnection();
					PreparedStatement ps1=con.prepareStatement("insert into userdetails (firstName,middleName,lastName,city, state,age)values"
			 		+ "(?, ?,?,?,?,?)");
			   
		ps1.setString(1, firstName);
		ps1.setString(2, middleName);
		ps1.setString(3, lastName);
		ps1.setString(4, city);
		ps1.setString(5, state);
		ps1.setInt(6, age);
		int i=ps1.executeUpdate();
		System.out.println("User Detail Inserted Successfully....!");
		 }catch(Exception e) 
		 {
			 e.printStackTrace();
		 }
		 
	 }
		 public static void register() 
		 {
			Scanner sc=new Scanner(System.in);
			UserDetail u=new UserDetail();
	try
	{
		      System.out.println("*****-------******----------******");
			  System.out.println("@@ Welcome To Registration Form: @@");
			  System.out.println("*****-------******----------******");
				System.out.println("Enter your First Name:");
				String firstName=sc.next();
				System.out.println("Enter your Middle Name:");
				String middleName=sc.next();
				System.out.println("Enter your Last Name:");
				String lastName=sc.next();
				System.out.println("Enter your City Name:");
				String city=sc.next();
				System.out.println("Enter your State Name:");
				String state=sc.next();
				System.out.println("Enter your Age Name:");
				int age=sc.nextInt();
				
				u.userData(firstName, middleName, lastName, city, state,age);
		 
	}catch(Exception e)
	{
		System.out.println(e);
	}
	finally
	{
			sc.close();
	}


}
}