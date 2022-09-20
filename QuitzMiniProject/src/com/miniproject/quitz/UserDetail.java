package com.miniproject.quitz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDetail {

	public static void userData(String firstName, String lastName, String userName, String passKey) throws Exception {

		try {
			DatabaseConnection data = new DatabaseConnection();
			Connection connection = data.getConnection();

			PreparedStatement ps1 = connection.prepareStatement(
					"insert into userdetail (firstName,lastName,userName,passKey)values" + "(?,?,?,?)");

			ps1.setString(1, firstName);
			ps1.setString(2, lastName);
			ps1.setString(3, userName);
			ps1.setString(4, passKey);

			int i = ps1.executeUpdate();
			System.out.println(i);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void register() {
		Scanner sc = new Scanner(System.in);
		UserDetail u = new UserDetail();
		try {
			System.out.println();
			System.out.println("----------******-------******-------******----------");
			System.out.println("---------   Welcome To Registration Form   ---------");
			System.out.println("----------******-------******-------******----------\n");
			System.out.println("Enter your First Name:");
			String firstName = sc.next();
			System.out.println("Enter your Last Name:");
			String lastName = sc.next();
			System.out.println("Enter your user Name:");
			String userName = sc.next();
			System.out.println("Enter your Password:");
			String passKey = sc.next();

			userData(firstName, lastName, userName, passKey);

			System.out.println("Registered Successfully....\n You can Login Now");
			System.out.println();
			Test.userMenu();

		} catch (Exception e) {

			System.out.println(e);

		} finally {
			sc.close();
		}

	}
}
