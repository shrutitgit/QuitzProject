package com.miniproject.quitz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class StudentMarks{
		
	int marks;
	Connection con = null;
	HashMap<Object,String> map1 = new HashMap<Object,String>();

	public int getMarks() {
			QuitzQuestions qq = new QuitzQuestions();
			
			try {
				DatabaseConnection dc = new DatabaseConnection();
				con = dc.getConnection();
				
//				while(qq.map.size()>0) {
//					String string = qq.map.get(1);
//					System.out.println(string);
//				}
				PreparedStatement ps = con.prepareStatement("Select sr,answer from Questions");
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) 
					map1.put(rs.getObject(1), rs.getString(2));
				
				System.out.println(map1);
				HashMap<Object, String> map = qq.map;

				System.out.println(map);
				
				
				Set<Object> keySet = qq.map.keySet();
				Iterator<Object> itr = keySet.iterator();
				while(itr.hasNext()) {
					if(map1.entrySet().containsAll(qq.map.entrySet())){
							marks++;
						}
					
				}
				System.out.println("Total Score out of 10 is "+marks);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return marks;
		}
	

}
