package com.miniproject.quitz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
	
	HashMap<Object,String> map = new HashMap<Object,String>();
	HashMap<Object,String> map1 = new HashMap<Object,String>();
	public void getQuestions() throws SQLException {
		
		try {
			DatabaseConnection dc = new DatabaseConnection();
			con = dc.getConnection();
			PreparedStatement ps = con.prepareStatement("Select sr,question,option1 as a,option2 as b,"
					+ "option3 as c, option4 as d from Questions order by rand() limit 2");
			ResultSet rs = ps.executeQuery();	
			
			while(rs.next()) {
				System.out.println("Question: "+num+" ");
				System.out.println("Que. "+rs.getString(2));	
				System.out.println("A : "+rs.getString(3));
				System.out.println("B : "+rs.getString(4));
				System.out.println("C : "+rs.getString(5));
				System.out.println("D : "+rs.getString(6)+"\n");
				System.out.println("Enter your choice: ");
				choice = sc.nextLine();
				
				map.put(rs.getObject(1),choice.toLowerCase());
				num++;
			}
		
			System.out.println(map);
			ps.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();	
		}	
		finally {
			sc.close();
			con.close();
		}
	
	}
	
public int getMarks() {
		
		try {
			DatabaseConnection dc = new DatabaseConnection();
			con = dc.getConnection();
			PreparedStatement ps = con.prepareStatement("Select sr,answer from Questions");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
				map1.put(rs.getObject(1), rs.getString(2));
			
			System.out.println(map1);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return num;
	}
	
	
	public static void main(String[] args) {
		QuitzQuestions qQuestions = new QuitzQuestions();
		try {
			qQuestions.getQuestions();
			qQuestions.getMarks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}

}
