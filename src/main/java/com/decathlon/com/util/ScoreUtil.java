package com.decathlon.com.util;

import com.decathlon.com.enums.Games;

public class ScoreUtil {
	/**
	 * This method will be used to calculate total score
	 * @param games - Decathlon game result
	 * @return totalScore 
	 */
	public static double caluclateScore(String[] games) {

		double score = 0;

		for (int i = 1; i < games.length; i++) {
			Games game = Games.getGameByNumber(i);

			if (game.getScoreIn().equals("S")) {
				double gameSocre = Double.parseDouble(games[i]);
				score = score + Math.floor(Math.pow((game.b - gameSocre), game.c) * game.a);
			} else if (game.getScoreIn().equals("M")) {
				double gameSocre = Double.parseDouble(games[i]);
				Double pow = Math.pow((gameSocre - game.b), game.c);
				if (pow.isNaN()) {
					score = score + 0;
				} else {
					score = score + Math.floor(pow * game.a);
				}
			} else if (game.getScoreIn().equals("M:S")) {
				String[] a = games[i].split(":");
				double gameSocre = Double.parseDouble(a[0]) * 60 + Double.parseDouble(a[1]);
				score = score + Math.floor(Math.pow((game.b - gameSocre), game.c) * game.a);
			}
		}

		return score;

	}
}
