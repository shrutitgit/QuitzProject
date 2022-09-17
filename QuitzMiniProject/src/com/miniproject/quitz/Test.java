package com.miniproject.quitz;

public class Test {

	public static void main(String[] args) {
		
		QuitzQuestions qQuestions = new QuitzQuestions();
	//	StudentMarks marks = new StudentMarks();

		try {
			qQuestions.getQuestions();
			qQuestions.getMarks();	
			System.out.println("Test method");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
