package com.miniproject.quitz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

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
	
	public void getQuestions() throws SQLException {
		
		try {
			DatabaseConnection dc = new DatabaseConnection();
			con = dc.getConnection();
			PreparedStatement ps = con.prepareStatement("Select sr,question,option1 as a,option2 as b,"
					+ "option3 as c, option4 as d from Questions order by rand() limit 5");
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
	
	int marks;
	HashMap<Object,String> map1 = new HashMap<Object,String>();
	public void getMarks() {
		
		try {
			DatabaseConnection dc = new DatabaseConnection();
			con = dc.getConnection();
			PreparedStatement ps = con.prepareStatement("Select sr,answer from Questions");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
				map1.put(rs.getObject(1), rs.getString(2));
			System.out.println(map1);			
	

			Set<Object> keySet = map.keySet();
			Iterator<Object> itr = keySet.iterator();
			while(itr.hasNext()) {	
				Object next2 = itr.next();
				System.out.println(next2);
//				Set<Object> keySet2 = map1.keySet();
//				Iterator<Object> itr1 = keySet2.iterator();
//				while(itr1.hasNext()) {
//					Object next = itr1.next();
//					if(next==next2) {
//						marks++;
//					}
//				}
//				boolean equals = map1.equals(itr.next());
//				
//				System.out.println("Returns: "+equals);
//				if(map1.entrySet().containsAll(itr.next())){
//						marks++;
//					}
				
			}
			System.out.println("Total Score out of 10 is "+marks);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
