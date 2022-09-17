package com.miniproject.quitz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class QuitzQuestions {

	int num=1;
	Connection con=null;
	int qresult[];
	String choice;
	Scanner sc = new Scanner(System.in);

//	public int getChoice() {
//		int n=1;
//		String s = choice.toLowerCase();
//		for(int i=0;i<s.length();i++) {
//			if(s.charAt(0)>'a' && s.charAt(i)<'d') {
//				System.err.println("Incorrect choice");
//				System.out.println("Kindly re-enter correct choice");
//				n=0;
//			}
//		}
//		return n;
//	}
	
	
	public void getQuestions() {
		QuitzQuestions ch = new QuitzQuestions();
		ArrayList<String> list = new ArrayList<String>();
		try {
			DatabaseConnection dc = new DatabaseConnection();
			con = dc.getConnection();
			PreparedStatement ps = con.prepareStatement("Select question,option1 as a,option2 as b,option3 as c, option4 as d from Questions order by rand()");
			ResultSet rs = ps.executeQuery();	
			
			
			while(rs.next()) {
				System.out.println("Question: "+num+" ");
				System.out.println("Que. "+rs.getString(1));	
				System.out.println("A : "+rs.getString(2));
				System.out.println("B : "+rs.getString(3));
				System.out.println("C : "+rs.getString(4));
				System.out.println("D : "+rs.getString(5)+"\n");
				System.out.println("Enter your choice: ");
				choice = sc.nextLine();
				
				list.add(choice.toLowerCase());
				num++;
				
				
			}
			
			System.out.println(list);
			
		}catch(Exception e) {
			e.printStackTrace();	
		}	
	}
	
	public static void main(String[] args) {
		QuitzQuestions qQuestions = new QuitzQuestions();
		qQuestions.getQuestions();
			
	}

}
