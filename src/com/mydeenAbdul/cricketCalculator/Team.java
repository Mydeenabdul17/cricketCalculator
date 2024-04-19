package com.mydeenAbdul.cricketCalculator;

import java.util.List;

public class Team {

	private String teamName;
	private List<Batsman> batsmans;
	private List<Bowler> bolwers;
	private int run;
	private int extra;
	private int noOfBalls;
	private int noOfWickets;
	private String status;

	public Team(String teamName, List<Batsman> batsmans, List<Bowler> bolwers, int extra, int noOfBalls, int run,
			int noOfWickets) {
		super();
		this.teamName = teamName;
		this.batsmans = batsmans;
		this.bolwers = bolwers;
		this.extra = extra;
		this.noOfBalls = noOfBalls;
		this.run = run;
		this.noOfWickets = noOfWickets;
	}

	public Team() {

	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Batsman> getBatsmans() {
		return batsmans;
	}

	public void setBatsmans(List<Batsman> batsmans) {
		this.batsmans = batsmans;
	}

	public List<Bowler> getBolwers() {
		return bolwers;
	}

	public void setBolwers(List<Bowler> bolwers) {
		this.bolwers = bolwers;
	}

	public int getExtra() {
		return extra;
	}

	public void setExtra(int extra) {
		this.extra = extra;
	}

	public int getNoOfBalls() {
		return noOfBalls;
	}

	public void setNoOfBalls(int noOfBalls) {
		this.noOfBalls = noOfBalls;
	}

	public int getRun() {
		return run;
	}

	public void setRun(int run) {
		this.run = run;
	}

	public int getNoOfWickets() {
		return noOfWickets;
	}

	public void setNoOfWickets(int noOfWickets) {
		this.noOfWickets = noOfWickets;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", batsmans=" + batsmans + ", bolwers=" + bolwers + ", run=" + run
				+ ", extra=" + extra + ", noOfBalls=" + noOfBalls + ", noOfWickets=" + noOfWickets + "]";
	}

}
