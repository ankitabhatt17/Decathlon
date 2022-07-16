package com.decathlon.com.enums;


import java.util.HashMap;
import java.util.Map;


public enum Games {

	METER_100_RACE(1, 25.4347, 18, 1.81, "S"),
	LONG_JUMP(2, 0.14354, 220, 1.4,"M"),
	SHOT_PUT(3, 51.39, 1.5, 1.05, "M"),
	HIGH_JUMP(4, 0.8465, 75, 1.42, "M"),
	METER_400_RACE(5, 1.53775, 82, 1.81, "S"),
	HURDLES_110_M(6, 5.74352, 28.5, 1.92, "S"),
	DISCUS_THROW(7, 12.91, 4, 1.1,"M"), 
	POLE_VAULT(8, 0.2797, 100, 1.35, "M"),
   JAVELIN_THROW(9, 10.14, 7, 1.08, "M"),
	METER_1500(10, 0.03768, 480, 1.85, "M:S");

	Games(int gameNo, double a, double b, double c, String s) {
		this.gameNo = gameNo;
		this.a = a;
		this.b = b;
		this.c = c;
		this.scoreIn = s;
	}

	private static final Map<Integer, Games> lookup = new HashMap<Integer, Games>();

	static {
		for (Games g : Games.values()) {
			lookup.put(g.getNumebr(), g);
		}
	}

	public final double a;
	public final double b;
	public final double c;
	public final int gameNo;
	public final String scoreIn;

	public double getA() {

		return a;
	}

	public double getB() {

		return b;
	}

	public double getC() {

		return c;
	}

	public int getNumebr() {

		return gameNo;
	}
	
	public String getScoreIn() {

		return scoreIn;
	}

	public static Games getGameByNumber(int gameNo) {

		return lookup.get(gameNo);
	}
	
	
}

