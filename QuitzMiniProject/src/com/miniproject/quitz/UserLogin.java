package com.miniproject.quitz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserLogin {

	Scanner sc = new Scanner(System.in);

	public void loginUse() {

		System.out.println("Enter Your Register Name :");
		String name = sc.next();
		System.out.println("Enter Your Seat Number");
		int number = sc.nextInt();
		System.out.println("Enter your Password :");
		String password = sc.next();

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		UserLogin login = new UserLogin();
		UserDetail u = new UserDetail();

		try {
			System.out.println("\n");
			System.out.println("-------***WELCOME To QUIZ***-------");
			System.out.println("-------------------------------------");
			System.out.println("ENTER :" + " " + "1>>Register" + "" + " 2>>Login>>" + "3>>Exit");
			int i = sc.nextInt();
			if (i == 1) {
				UserDetail.register();
			} else if (i == 2) {
				login.loginUse();
			} else {
				System.out.println("Invalid Input");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
