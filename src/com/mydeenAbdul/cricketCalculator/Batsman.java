package com.mydeenAbdul.cricketCalculator;

public class Batsman {

	private String name;
	private int runs;
	private int balls;
	private boolean isOut;

	public Batsman(String name, int runs, int balls, boolean isOut) {
		super();
		this.name = name;
		this.runs = runs;
		this.balls = balls;
		this.isOut = isOut;
	}

	public Batsman() {

	}

	@Override
	public String toString() {
		return "Batsman [name=" + name + ", runs=" + runs + ", balls=" + balls + ", isOut=" + isOut + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	public boolean isOut() {
		return isOut;
	}

	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}

}
