package lab6;

import java.util.Random;
import java.util.Scanner;

public class GCCasino {

	public static void main(String[] args) {
		boolean decision = true;

		System.out.println("Welcome to the Grand Circus Casino!");

		System.out.println();

		whileLoop(decision);
	}

	private static void whileLoop(boolean decision) {
		try (Scanner scnr = new Scanner(System.in)) {
			while (decision) {

				System.out.println("Would you like to try your luck and roll those dice?");
				System.out.print("Enter 1 for the casino floor or 0 if you're under 21. ");

				System.out.println();

				int chance = scnr.nextInt();

				switchStatement(scnr, chance);

				System.out.println();

				System.out.println("Would you like to try your luck again? (y/n):");

				String answer = scnr.next().toLowerCase();

				if (answer.equals("n")) {
					decision = false;
					System.out.println("Thanks for playing! Better luck next time!");
				}
			}
		}
	}

	private static void switchStatement(Scanner scnr, int chance) {
		switch (chance) {
		case 1:
			System.out.println("How many sides should each die have?");
			int diceSides = Math.abs(scnr.nextInt());
            
			System.out.println("Roll 1:");
			int roll1 = generateRandomDieRoll(diceSides);
			int roll2 = generateRandomDieRoll(diceSides);
			System.out.println(roll1);
			System.out.println(roll2);

			funTimeRolls(roll1, roll2);

			break;
		case 0:
			System.out.println("Sorry you can't join us. Welcome to the casino daycare!");
			return;
		default:
			System.out.println("Invalid choice. Enter 1 or 0.");
			break;
		}
	}

	private static int generateRandomDieRoll(int diceSides) {
		Random randGen = new Random();
		int roll = randGen.nextInt(diceSides) + 1;
		return roll;
	}

	private static void funTimeRolls(int roll1, int roll2) {

		if (roll1 == roll2) {
			System.out.println("You rolled snake eyes!");
		} else if (roll1 == 2 && roll2 == 2) {
			System.out.println("You rolled ballerina!");
		} else if (roll1 == 3 && roll2 == 3) {
			System.out.println("You rolled brooklyn forest!");
		} else if (roll1 == 4 && roll2 == 4) {
			System.out.println("You rollled a square pair!");
		} else if (roll1 == 5 && roll2 == 5) {
			System.out.println("You rolled puppy paws! Yay!");
		} else if (roll1 == 6 && roll2 == 6) {
			System.out.println("You rolled box cars!");
		} else if (roll1 + roll2 == 7) {
			System.out.println("You rolled craps!");
		}
	}

}
