package com.miniproject.quitz;

import java.util.Scanner;

public class Test {
	public static void userMenu() {
		int menuChoice = 0;

		try {

			while (menuChoice != 5) {
				System.out.println("Enter :" + " " + "1.Register" + "" + " 2.Login" + " 3.ScoreCard>>" + " 5.Exit");
				Scanner sc = new Scanner(System.in);

				menuChoice = sc.nextInt();
				switch (menuChoice) {
				case 1:
					UserDetail.register();

					break;
				case 2:

					UserLogin.checkUser();
					break;
				case 3:
					
					System.out.println("ScoreCard");
					break;
				case 5:
					System.out.println("Exit 0");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Selection....");
					break;
				}
			};

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void innerMenu() {
		int menuChoice = 0;

		try {

			while (menuChoice != 5) {
				System.out.println("Enter :" + " " + "1.Start Test" + " " + " 2.View Result " + " 3.MainMenu "+" 5.Exit ");
				Scanner sc = new Scanner(System.in);

				menuChoice = sc.nextInt();
				switch (menuChoice) {
				case 1:
					QuitzQuestions qQuestions = new QuitzQuestions();
					qQuestions.getQuestions();
					break;
				case 2:
					QuitzQuestions qQuestion = new QuitzQuestions();
					qQuestion.getMarks();	
					break;
				case 3:
					userMenu();
					System.out.println("Main Menu");
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Selection....");
					break;
				}
			};
		}catch(Exception e) {
			
		}
	}
	public static void main(String[] args) {
		
//		UserLogin login = new UserLogin();
//		UserDetail u = new UserDetail();
	System.out.println("-------***-WELCOME To QUIZ Appplication-***-------");
		System.out.println("---------------------------------------------------");

		userMenu();

		
		
	}

}
