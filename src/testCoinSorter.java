/*
 * Test class for the Coin Sorter Program. 
 */

import java.util.*;

public class testCoinSorter {

	public static void main(String[] args) {

		// Initializing the program parameters with the default values
		List<Integer> coinList = new ArrayList<Integer>(List.of(200, 100, 50, 20, 10));

		CoinSorter cs = new CoinSorter("Pound Sterling (£)", 0, 10000, coinList);

		int choice;

		Scanner sc = new Scanner(System.in);

		// Creating a Textual Menu for the 6 options
		do {
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("*** Coin Sorter - Main Menu ***");
			System.out.println("1 - Coin Calculator");
			System.out.println("2 - Multiple Coin Calculator");
			System.out.println("3 - Print coin list");
			System.out.println("4 - Set details");
			System.out.println("5 - Display Program configurations");
			System.out.println("6 - Quit the program");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				// Case 1 prompts the user to enter two values calls the coinCalculator method
				System.out.println("What's the value you want to exchange?");
				int valueToExchange = sc.nextInt();
				// Validate the value to exchange, making sure it falls between the minimum and
				// maximum value
				if ((valueToExchange <= cs.getMaxCoinIn()) & (valueToExchange >= cs.getMinCoinIn())) {
					System.out.println("What type of coin do you want to receive?");
					int coinType = sc.nextInt();
					// Validate the coin type, making sure it is a denomination in circulation
					if (((coinType == coinList.get(0)) || (coinType == coinList.get(1)) || (coinType == coinList.get(2))
							|| (coinType == coinList.get(3)) || (coinType == coinList.get(4)))) {
						// if all the validations pass, calculate the coin value
						String result = cs.coinCalculator(valueToExchange, coinType);
						System.out.println(result);
						// if the validation fails, print hints.
					} else {

						System.out.println("The coin type has to be one of these: 200, 100, 50, 20 or 10");
					}

				} else {
					System.out.println("The exchangable value has to be between " + cs.getMaxCoinIn() + " and "
							+ cs.getMinCoinIn());
				}
				break;
			case 2:
				// Case 2 prompts the user to enter two values calls the multiCoinCalculator
				// method
				System.out.println("What's the value you want to exchange?");
				int valueToExchange2 = sc.nextInt();
				// Validate the value to exchange, making sure it falls between the minimum and
				// maximum value
				if ((valueToExchange2 <= cs.getMaxCoinIn()) & (valueToExchange2 >= cs.getMinCoinIn())) {
					System.out.println("What type of coin do you want to exclude?");
					int coinTypeToExclude = sc.nextInt();
					// Validate the coin type, making sure it is a denomination in circulation
					if (((coinTypeToExclude == coinList.get(0)) || (coinTypeToExclude == coinList.get(1))
							|| (coinTypeToExclude == coinList.get(2)) || (coinTypeToExclude == coinList.get(3))
							|| (coinTypeToExclude == coinList.get(4)))) {
						// if all the validations pass, calculate the multi coin value
						String result = cs.multiCoinCalculator(valueToExchange2, coinTypeToExclude);
						System.out.println(result);
						// if the validation fails, print hints.

					} else {
						System.out.println("The coin type has to be one of these: 200, 100, 50, 20 or 10");
					}

				} else {
					System.out.println("The exchangable value has to be between " + cs.getMaxCoinIn() + " and "
							+ cs.getMinCoinIn());
				}
				break;

			case 3:
				// Case 3 calls the printCoinList method
				cs.printCoinList();
				break;
			case 4:
				// Case 4 creates a sub-menu
				int subChoice;
				do {
					System.out.println(" ");
					System.out.println(" ");
					System.out.println("*** Set Details Sub Menu ***");
					System.out.println("1 - Set Currency");
					System.out.println("2 - Set minimum coin input value");
					System.out.println("3 - Set maximum coin input value");
					System.out.println("4 - Return to main menu");
					subChoice = sc.nextInt();
					switch (subChoice) {
					case 1:
						// Case 1 prompts for a currency input and resets the currency
						System.out.println("New currency: ");
						String currencyIn = sc.next();
						cs.setCurrency(currencyIn);
						break;
					case 2:
						// Case 2 prompts for a minimum value input and resets the minimum coin value
						System.out.println("New minimum coin input value: ");
						int newMin = sc.nextInt();
						cs.setMinCoinIn(newMin);
						break;
					case 3:
						// Case 3 prompts for a maximum value input and resets the minimum coin value
						System.out.println("New maximum coin input value: ");
						int newMax = sc.nextInt();
						cs.setMaxCoinIn(newMax);
						break;

					}
					// Choice 4 quits the sub-menu
				} while (subChoice != 4);
				break;
			case 5:
				// Case 5 calls and prints the program settings
				String result = cs.displayProgramConfig();
				System.out.println(result);
				break;

			}
			// Choice 6 quits the program
		} while (choice != 6);
	}

}
