package com.decathlon.com;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.decathlon.com.model.Athlete;
import com.decathlon.com.model.Athlets;
import com.decathlon.com.util.ScoreUtil;

public class ReadFromCSV implements CompetitionResult {

	private String line = "";
	private String splitBy = ";";
	private List<Athlete> listOfAthlete = new ArrayList<Athlete>();
	private Athlets athlets = new Athlets();

	
	public void readDecathlonResult(String path, String resultFilePath) {
		try {

			BufferedReader br = new BufferedReader(new FileReader(path));

			while ((line = br.readLine()) != null) {
				String[] employee = line.split(splitBy);

				mapAthelete(employee, listOfAthlete);
					
				listOfAthlete.stream().sorted(Comparator.comparingDouble(Athlete::getTotalScore).reversed());

				assignRank();

				athlets.setListOfAthlete(listOfAthlete);

				CreateXML.createXMLFile(athlets, resultFilePath);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void assignRank() {
		int rank = 1;
		for (int i = 0; i < listOfAthlete.size(); i++) {
			listOfAthlete.get(i).setRank(rank);
			rank++;
		}
	}

	private void mapAthelete(String[] games, List<Athlete> listOfAthlete) {

		if (!games[0].isEmpty()) {

			Athlete a = new Athlete();
			a.setName(games[0]);
			a.setTotalScore(ScoreUtil.caluclateScore(games));

			listOfAthlete.add(a);
		}
	}

}

