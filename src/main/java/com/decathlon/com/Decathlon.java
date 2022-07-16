package com.decathlon.com;


public class Decathlon {
	public static void main(String st[]) {
		
		String resultFilePath = "src/main/resources/results.csv";
	    String finalResultFilePath = "src/main/resources/finalResult.xml";
		String extension = resultFilePath.substring(resultFilePath.lastIndexOf(".")+1);
		CompetitionResult result = null;
		if(extension.equals("csv")) {
		result  = new ReadFromCSV();
		result.readDecathlonResult(resultFilePath, finalResultFilePath);
		} else {
			// Here we can create other implementation
		}
	}

}

