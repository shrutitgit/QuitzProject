package com.miniproject.quitz;

public class Test {

	public static void main(String[] args) {
		
		QuitzQuestions qQuestions = new QuitzQuestions();

		try {
			qQuestions.getQuestions();
			qQuestions.getMarks();	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
