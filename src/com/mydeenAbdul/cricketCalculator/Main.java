package com.mydeenAbdul.cricketCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	Scanner sc = new Scanner(System.in);
	private Repository repository = Repository.getInstance();

	public static void main(String[] args) {
		/*
		 * punjab,chennai smith,dhawan,agarwal,patel,singh
		 * dhoni,conway,rayudu,bravo,jadeja 0,1,0wd,1,6,0,1 w,0,0,2,1,1 1,2,2,4,0,1
		 * 4,4,2,0nb,6,4,w
		 * 
		 * 0,0,1,4,2,0 0,1,6,w,0,0 4,4,6,0wd,1,1,1 0nb,4,2,1,0,6
		 */
		Main m = new Main();
		m.getInput();
		m.repository.calculate();
	}

	private void getInput() {
//		System.out.println("Enter teams name");
		String t1 = sc.next();
		String t2 = sc.next();
//		System.out.println("Enter playes name of team1");
		List<Batsman> t1Batsman = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			String batsman = sc.next();
			t1Batsman.add(new Batsman(batsman, 0, 0, false));
		}
		List<Bowler> t1Bowlers = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			String bowler = sc.next();
			t1Bowlers.add(new Bowler(bowler, 0, 0, 0));
		}
//		System.out.println("Enter player names of team2");
		List<Batsman> t2Batsman = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			String batsman = sc.next();
			t2Batsman.add(new Batsman(batsman, 0, 0, false));
		}
		List<Bowler> t2Bowlers = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			String bowler = sc.next();
			t2Bowlers.add(new Bowler(bowler, 0, 0, 0));
		}
		repository.addTeam(new Team(t1, t1Batsman, t1Bowlers, 0, 0, 0, 0),
				new Team(t2, t2Batsman, t2Bowlers, 0, 0, 0, 0));
		sc.nextLine();
//		System.out.println("Enter team1 score");
		String team1Score = sc.nextLine();
//		System.out.println("Enter team2 score");
		String team2Score = sc.nextLine();
		repository.scoreInput(team1Score, team2Score);
	}
}
