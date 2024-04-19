package com.mydeenAbdul.cricketCalculator;

public class Bowler {

	private String name;
	private int runs;
	private int balls;
	private int wickets;

	public Bowler(String name, int runs, int balls, int wickets) {
		super();
		this.name = name;
		this.runs = runs;
		this.balls = balls;
		this.wickets = wickets;
	}

	public Bowler() {

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

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	@Override
	public String toString() {
		return "Bowler [name=" + name + ", runs=" + runs + ", balls=" + balls + ", wickets=" + wickets + "]";
	}

}
