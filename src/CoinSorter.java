/*
 * Main class for the Coin Sorter Program. 
 * The program enables users to execute a variety of options to exchange coins.
 */

import java.util.ArrayList;
import java.util.List;

public class CoinSorter {

	String currency;
	int minCoin;
	int maxCoin;
	List<Integer> coinList;

	// Constructor +CoinSorter(String, int, int, List<Integer>) allows users to set
	// the initial values
	public CoinSorter(String currencyIn, int minCoinIn, int maxCoinIn, List<Integer> coinListIn) {

		currency = currencyIn;
		minCoin = minCoinIn;
		maxCoin = maxCoinIn;
		coinList = coinListIn;

	}

	// Constructor +CoinSorter() to define the default values without user input.
	public CoinSorter() {
		currency = " Pound Sterling £";
		minCoin = 0;
		maxCoin = 10000;
		coinList = new ArrayList<Integer>(List.of(200, 100, 50, 20, 10));

	}

	// Method to set the currency
	public void setCurrency(String currencyIn) {
		currency = currencyIn;
		System.out.println("The new currency is " + currency);
	}

	// Method to set the minimum accepted value
	public void setMinCoinIn(int minCoinIn) {
		minCoin = minCoinIn;
		System.out.println("The new minimum value is is " + minCoin);

	}

	// Method to set the maximum accepted value
	public void setMaxCoinIn(int maxCoinIn) {
		maxCoin = maxCoinIn;
		System.out.println("The new maximum value is is " + maxCoin);

	}

	// Method to return the current currency.
	public String getCurrency() {
		return currency;
	}

	// Method to return the minimum accepted coin amount
	public int getMinCoinIn() {
		return minCoin;
	}

	// Method to return the maximum accepted coin amount
	public int getMaxCoinIn() {
		return maxCoin;
	}

	// Method to print and return the coin denominations in circulation
	public String printCoinList() {

		StringBuilder displayDetails = new StringBuilder();
		displayDetails.append("The current coin denomiations are in circulation: ");
		// Appending each element of the coinList to the String so that we can return a
		// String
		for (int i = 0; i < coinList.size(); i++) {
			displayDetails.append(coinList.get(i));
			displayDetails.append(", ");
		}
		System.out.println(displayDetails.toString());

		return displayDetails.toString();
	}

	// Method to calculate the maximum number of coins of the desired coin type and
	// the remainder, and return them as a String
	public String coinCalculator(int valueToExchange, int coinType) {
		int numCoins = valueToExchange / coinType;
		int remainder = valueToExchange % coinType;

		String result = "A total of " + numCoins + " x " + coinType + "p coins can be exchanged with a remainder of "
				+ remainder + "p.";

		return result;

	}

	// Method to calculate the number of coins (higher denominations preferred)
	// exchangeable while excluding a defined coin type.
	public String multiCoinCalculator(int valueToExchange, int coinTypeToExclude) {
		// First removing the given coin from the coinList
		int index = coinList.indexOf(coinTypeToExclude);
		coinList.remove(index);
		// Then creating variables to store out results
		int[] returnCoinList = new int[4];
		int numCoins;
		// Looping through the coin list (starting from the highest denomination) and
		// adding how many coins we can exchange from each denomination to the
		// returnCoinList

		for (int i = 0; i < coinList.size(); i++) {
			numCoins = valueToExchange / coinList.get(i);
			returnCoinList[i] = numCoins;
			valueToExchange = valueToExchange - (numCoins * coinList.get(i));
		}
		// Creating a string with the results. Since the coinList is not changeable in
		// the program, it will always have 5 elements and thus after excluding one, it
		// will always have 4 elements in the returnCoinList
		String result = "The coins exchanged are: " + returnCoinList[0] + " x " + coinList.get(0) + "p, "
				+ returnCoinList[1] + " x " + coinList.get(1) + "p, " + returnCoinList[2] + " x " + coinList.get(2)
				+ "p, " + returnCoinList[3] + " x " + coinList.get(3) + "p with a remainder of " + valueToExchange;

		// Add the excluded coin back to the list sat the correct index so that it's
		// included for further methods
		coinList.add(index, coinTypeToExclude);

		return result;
	}

	// Method to return the current settings of the program
	public String displayProgramConfig() {

		String result = "The current currency is " + currency + ", the minimum value accepted is " + minCoin
				+ ", and the maximum value accepted is " + maxCoin;
		return result;
	}

}
