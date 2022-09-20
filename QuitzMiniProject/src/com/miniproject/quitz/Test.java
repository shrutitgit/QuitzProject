package com.miniproject.quitz;

import java.util.Scanner;

public class Test {
	public static void userMenu() {
		int menuChoice = 0;

		try {

			while (menuChoice != 5) {
				System.out.println("====================================================");
				System.out.println("                      MAIN MENU                     ");
				System.out.println("====================================================");
				System.out.println("(1) Register\n" + "" + "(2) Login\n" + "(3) ScoreCard\n" + "(5) Exit");
				System.out.print("Enter Your choice: ");
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
			}
			;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void innerMenu() {
		int menuChoice = 0;

		try {

			while (menuChoice != 5) {
				
				System.out.println("(1) Start Test\n" + "(2) View Result \n" + "(3) MainMenu \n" + "(5) Exit ");
				System.out.println("Enter Your Choice :");
				Scanner sc = new Scanner(System.in);
				menuChoice = sc.nextInt();
				
				switch (menuChoice) {
				case 1:
					QuitzQuestions qQuestions = new QuitzQuestions();
					qQuestions.getQuestions();
					break;
				case 2:
					QuitzQuestions qQuestion = new QuitzQuestions();
					qQuestion.getMarks(); //Marks score card
					break;
				case 3:
					userMenu(); //MainMenu
					break;
				case 5:
					System.out.println("      * * * * * THANK YOU * * * * *     ");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Selection....\n");
					break;
				}
			};
			
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		System.out.println("**************************************************");
		System.out.println("-----***   WELCOME To QUIZ Appplication   ***-----");
		System.out.println("**************************************************");

		userMenu();

	}

}
