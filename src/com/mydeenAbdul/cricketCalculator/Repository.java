package com.mydeenAbdul.cricketCalculator;

import java.util.LinkedList;
import java.util.Queue;

public class Repository {

	private Team team1, team2;
	private String team1Score, team2Score;
	private static Repository repository;
	private int maxWicket;

	private Repository() {

	}

	public static Repository getInstance() {
		if (repository == null)
			repository = new Repository();
		return repository;
	}

	public void addTeam(Team team1, Team team2) {
		this.team1 = team1;
		this.team2 = team2;
	}

	public void scoreInput(String team1Score, String team2Score) {
		this.team1Score = team1Score;
		this.team2Score = team2Score;
	}

	public void calculate() {
		calculate(team1Score, team1, team2);
		calculate(team2Score, team2, team1);
//		System.out.println(team1);
//		System.out.println(team2);
		if (team1.getRun() > team2.getRun()) {
			team1.setStatus("won");
			if (team2.getNoOfWickets() == 2) {
				team2.setStatus("all out");
			} else {
				team2.setStatus(team2.getNoOfWickets() + " out");
			}
		} else {
			team2.setStatus("won");
			if (team1.getNoOfWickets() == 2) {
				team1.setStatus("all out");
			} else {
				team1.setStatus(team1.getNoOfWickets() + " out");
			}
		}
		print(team1);
		print(team2);
	}

	private void calculate(String score, Team bating, Team bowling) {
		Batsman currentBatsMan = bating.getBatsmans().get(0);
		Batsman oppBatsman = bating.getBatsmans().get(1);
		Queue<Bowler> bowlers = new LinkedList<>();
		for (Bowler b : bowling.getBolwers()) {
			bowlers.offer(b);
		}
		Bowler currentBowler = bowlers.poll();
		int outCount = 0;
		boolean isWorNB = false;
		for (int i = 0; i < score.length(); i++) {
			isWorNB = false;
			if (score.charAt(i) == ',')
				continue;
			currentBatsMan.setBalls(currentBatsMan.getBalls() + 1);
			int currentScore = 0;
//			System.out.println(score.charAt(i)+" "+currentBatsMan.getName()+" "+currentScore);
			if (Character.isDigit(score.charAt(i))) {
				currentScore = score.charAt(i) - '0';
				currentBatsMan.setRuns(currentBatsMan.getRuns() + currentScore);
				currentBowler.setRuns(currentBowler.getRuns() + currentScore);
//				System.out.println(currentBatsMan.getName()+" - "+currentScore);
				if (currentScore % 2 != 0) {
					Batsman temp = currentBatsMan;
					currentBatsMan = oppBatsman;
					oppBatsman = temp;
				}
			} else if (score.charAt(i) == 'w' && (i == score.length() - 1 || score.charAt(i + 1) != 'd')) {
				currentBatsMan.setOut(true);
				outCount++;
				maxWicket = maxWicket < outCount ? outCount : maxWicket;
				bating.setNoOfWickets(outCount);
				currentBowler.setWickets(currentBowler.getWickets() + 1);
				if (outCount < 2) {
					currentBatsMan = bating.getBatsmans().get(2);
				}
			} else if (score.charAt(i) == 'n') {
				currentScore = 1;
				bating.setExtra(bating.getExtra() + 1);
				i++;
				currentBowler.setRuns(currentBowler.getRuns() + 1);
				isWorNB = true;
			} else if (i < score.length() - 1 && score.substring(i, i + 2).equals("wd")) {
				currentScore = 1;
				bating.setExtra(bating.getExtra() + 1);
				i++;
				currentBowler.setRuns(currentBowler.getRuns() + 1);
				isWorNB = true;
			}
			if (isWorNB) {

				currentBatsMan.setBalls(currentBatsMan.getBalls() - 1);
				bating.setNoOfBalls(bating.getNoOfBalls() - 1);
				currentBowler.setBalls(currentBowler.getBalls() - 1);
			} else {
				bating.setNoOfBalls(bating.getNoOfBalls() + 1);
				currentBowler.setBalls(currentBowler.getBalls() + 1);
			}
			if (currentBowler.getBalls() % 6 == 0 && !isWorNB) {
//				System.out.println("Over change");
				bowlers.offer(currentBowler);
				currentBowler = bowlers.poll();
				Batsman temp = currentBatsMan;
				currentBatsMan = oppBatsman;
				oppBatsman = temp;
			}
			bating.setRun(bating.getRun() + currentScore);
		}
	}

	public void print(Team team) {
		System.out.println(
				"***********************************************************************************************");
		System.out.println("Team Output");
		System.out.println(team.getTeamName() + " - " + team.getRun() + "/" + team.getNoOfWickets() + "("
				+ team.getStatus() + "," + (team.getNoOfBalls() / 6) + "." + (team.getNoOfBalls() % 6) + " overs)");
		System.out.println("\nbatting:\n");
		for (Batsman b : team.getBatsmans()) {
			if(!b.isOut()) {
				b.setName(b.getName()+"*");
			}
			System.out.println(b.getName() + "-" + b.getRuns() + " runs (" + b.getBalls() + " balls)");
		}
		System.out.println("Innings Extras - " + team.getExtra() + " runs");
		System.out.println("\nBowling:\n");
		for (Bowler b : team.getBolwers()) {
			System.out.println(b.getName() + "-" + (b.getBalls() / 6) + "." + (b.getBalls() % 6) + " overs - "
					+ b.getRuns() + "/" + b.getWickets());
		}
		System.out.println("\nPlayer States:\n");
		for (Batsman b : team.getBatsmans()) {
			int runs = b.getRuns();
			int balls = b.getBalls();
			double sr = Math.round(((double) runs / (double) balls) * 100);
			double c = Math.round(((double) runs / (double) team.getRun()) * 100);
			System.out.println(b.getName() + "-" + runs + "(" + balls + ")-SR " + sr + "% - c " + c + "%");
		}
		for (Bowler b : team.getBolwers()) {
			int wickets = b.getWickets();
			double c = Math.round(((double) wickets / (double) maxWicket) * 100);
			System.out.println(b.getName() + " - " + b.getRuns() + "/" + wickets + "(" + (b.getBalls() / 6) + "."
					+ (b.getBalls() % 6) + ") - w" + wickets + " -c " + c + "%");
		}
	}
}
