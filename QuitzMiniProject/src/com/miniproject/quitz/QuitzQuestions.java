package com.miniproject.quitz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;
import java.util.Set;

public class QuitzQuestions {

	int num = 1;
	Connection con = null;
	int qresult[];
	String choice;
	public static HashMap<Object, String> map = new HashMap<Object, String>();

	public void getQuestions() throws SQLException {
		Scanner sc = new Scanner(System.in);
		try {
			DatabaseConnection dc = new DatabaseConnection();
			con = dc.getConnection();
			PreparedStatement ps = con.prepareStatement("Select sr,question,option1 as a,option2 as b,"
					+ "option3 as c, option4 as d from Questions order by rand() limit 10");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("\nQuestion: " + num);
				System.out.println("Que. " + rs.getString(2));
				System.out.println("A : " + rs.getString(3));
				System.out.println("B : " + rs.getString(4));
				System.out.println("C : " + rs.getString(5));
				System.out.println("D : " + rs.getString(6));
				System.out.println("Enter your choice: ");
				choice = sc.nextLine();

				String s = choice.toLowerCase();
				char s1 = s.charAt(0);
				if (s1 >= 'a' && s1 <= 'd') {

				} else {
					System.err.println("Incorrect choice");
					System.out.println("\nKindly re-enter correct choice");
					choice = sc.nextLine();
				}

				map.put(rs.getObject(1), choice.toLowerCase());
				num++;
			}

			System.out.println("\n******************Test Submitted Successfully*******************\n");
	//		System.out.println(map);
			ps.close();
			rs.close();

		} catch (Exception e) {
			System.out.println("Exception in Questions");
			e.printStackTrace();
		} finally {
			// sc.close();
			con.close();
		}

	}

	
	int marks;
	public void getMarks(String uname) {
		String username=uname;
		HashMap<Object, String> map1 = new HashMap<Object, String>();
		
//		System.out.println("Username: "+username);
		try {
			DatabaseConnection dc = new DatabaseConnection();
			con = dc.getConnection();
			PreparedStatement ps = con.prepareStatement("Select sr,answer from Questions");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
				map1.put(rs.getObject(1), rs.getString(2));
//			System.out.println(map1);

			Set<Object> keySet = map1.keySet();
			Iterator<Object> itr = keySet.iterator();
			
			while(itr.hasNext()) {	
				Object value = itr.next();
				String key = map1.get(value);
				
				Set<Object> keySet2 = map.keySet();
				Iterator<Object> itr1 = keySet2.iterator();
				while(itr1.hasNext()) {
					Object value1 = itr1.next();
					String key1 = map.get(value1);	
						if(key.equals(key1)) {
							if(value.equals(value1))
							marks++;
						}
				}
			}
			
			System.out.println("\n********Total Score out of 10 is "+marks+"********\n");

			String grade = null;
			if(marks >= 9)
				grade="A";
			else if(marks >= 7)
				grade="B";
			else if(marks >= 4)
				grade="C";
			else
				grade="D";
				
			PreparedStatement ps1 = con.prepareStatement("Update userdetail set marks=?,grade=? where userName=?");
			ps1.setInt(1, marks);
			ps1.setString(2, grade);
			ps1.setString(3, username);
			ps1.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			}
		}
	
		public void getScoreBoard() throws SQLException {
			Scanner sc1 = new Scanner(System.in);
			DatabaseConnection db = new DatabaseConnection();
			con=db.getConnection();
			
			System.out.println("\n*** Only Admin can view the ScoreBoard ***\n");
			System.out.println("Username: ");
			String uname = sc1.next();
			System.out.println("Password: ");
			String pwd = sc1.next();
					
			if(uname.equals("Admin") && pwd.equals("admin")) {
				PreparedStatement ps2 = con.prepareStatement("Select * from userdetail order by marks ASC");
				ResultSet rs = ps2.executeQuery();
				while(rs.next()) {
					System.out.println("[Id: "+rs.getInt(1)+"] [FirstName: "+rs.getString(2)+"] [LastName: "+rs.getString(3)+"] [Username: "+rs.getString(4)+"] [Password: "+rs.getString(5)+"] [Marks: "+rs.getInt(6)+"] [Grade: "+rs.getString(7)+"]");
				}
			} else {
				System.out.println("Invalid username or password");
			}	
					
		}
}