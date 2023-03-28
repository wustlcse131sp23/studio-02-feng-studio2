package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What is your start amount?");
		int startAmount = scan.nextInt();
		System.out.println("What is your win chance?(%)");
		double winChance = scan.nextDouble();
		System.out.println("What is your win limit?");
		int winLimit = scan.nextInt();
		System.out.println("How many simulations would you like to run?");
		int totalSimulations = scan.nextInt();
		int simulationsRemaining = totalSimulations;
		int rounds = 0;
		int losses = 0;
		int wins = 0;
		int startAmountDuplicate = startAmount;
		int ruinCount = 0;
		double ruinRateExpected = 0;
		double a = (1-winChance)/winChance;
		
		for(simulationsRemaining=totalSimulations; simulationsRemaining>0; simulationsRemaining--) {
			while (startAmount<winLimit || startAmount==0) {
				double gameOutcome = (Math.random());
				if (gameOutcome<=winChance){
					startAmount++;
					rounds++;
					wins++;
				}
				else {
					startAmount--;
					losses++;
					rounds++;
				}
				}
			
			int simulationDay = totalSimulations-simulationsRemaining;
			System.out.println("Simulation day " + simulationDay + " has been completed.");
			System.out.println(rounds + " rounds took place today." + " There were " + wins + " wins and " + losses + " losses.");
			
			if (startAmount==winLimit) {
				System.out.println("The day ended successfully.");
			}
			else {
				System.out.println("The day ended in ruins.");
				ruinCount++;
			}	
			
			startAmount = startAmountDuplicate;
			rounds = 0;
			wins = 0;
			losses = 0;	
		}
		
		double ruinRate = ruinCount / totalSimulations;
		if (winChance == 0.5) {
			ruinRateExpected = 1-(startAmount/winLimit);
		}
		else {
			ruinRateExpected = (Math.pow(a, startAmount)-Math.pow(a, winLimit))/(1-(Math.pow(a, winLimit)));
		}
		
		System.out.println("Ruin rate from simulation: " + ruinRate);
		System.out.println("Expected ruin rate: " + ruinRateExpected);
	}
}

