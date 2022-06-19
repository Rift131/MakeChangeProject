package com.skilldistillery.makechange;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MakeChange {
	
	// global scanner
	static Scanner userInput = new Scanner(System.in);
	// global decimal format
	static DecimalFormat moneyFormat = new DecimalFormat("$#,###0.00");
	
	public static void main(String[] args) {
		/*
		 * In the cash register we will calculate the amount of change returned to a
		 * customer based on the purchase price and the amount tendered. We will also
		 * notify the attendant how many of each piece of currency ($20 ,$10 ,$5 ,$1,
		 * .25c, .10c, .05c, .01c) is needed to make the change for the customer. Change
		 * should be provided using the largest bill and coin denominations as possible.
		 * Denominations that are not used should not be displayed.
		 */		
		// invoke method customerPurchaseRequest();
		customerPurchaseRequest();
		// sysout Thank you for using the MakeChange program
		System.out.println("Thank you for using the \"Make Change\" program. Have a nice day!");
		// close the scanner
		userInput.close();
	}
	
	
	//method customerPurchaseRequest()
	public static void customerPurchaseRequest() {
		
		// ask user for price of item
		System.out.println("Please enter the total amount owed by the customer: ");
		// assign response value to a double formatted to DecimalFormat
		BigDecimal debt = BigDecimal.valueOf(userInput.nextDouble());
		// clear the scanner
		userInput.nextLine();
		
		// ask user for the amount tendered by customer
		System.out.println("\nPlease enter total amount tendered by customer: ");
		// assign response to a double var formatted to DecimalFormat
		BigDecimal tendered = BigDecimal.valueOf(userInput.nextDouble());
		// clear the scanner
		userInput.nextLine();
		
		// double var that is the delta of amount tendered and amount owed
		BigDecimal deltaOfDebtdTendered = tendered.subtract(debt);
		
		//BigDecimal to represent 0.00
		BigDecimal zero = BigDecimal.valueOf(0.00);
			
			// if the delta var is less than zero
			if (deltaOfDebtdTendered.compareTo(zero) < 0) {
				// invoke method remainingDebt(tendered, price, owed) 
			    remainingDebt(tendered, debt, deltaOfDebtdTendered);
			    // otherwise if the amount tendered is the amount owed
			} else if (deltaOfDebtdTendered.compareTo(zero) ==  0) {
			    	// invoke the exactChange method
				exactChange();
				// otherwise
			} else {
				// invoke method customerChangeCalculator(delta var)
				customerChangeCalculator(deltaOfDebtdTendered);
				}
			}
	
	// method: remainingBalance(double tendered, double owed)
	public static void remainingDebt(BigDecimal customerMoneyGiven, BigDecimal priceOfGoods, BigDecimal remainingBalanceOwed) {
		
		// (prompt a message indicating amount tendered, total price of goods and how much more is needed to zero out the balance (delta var * -1 to print a positive number for better readability). This is twofold: the message allows the user to verify they entered data correctly or tell the customer how much more money to provide to satisfy the debt.
		// also create BigDecimal for -1
		BigDecimal negOne = BigDecimal.valueOf(-1);
		System.out.println("\nAfter receiving " + moneyFormat.format(customerMoneyGiven) + " for a debt of " + moneyFormat.format(priceOfGoods) + ", the remaining balance is " + (moneyFormat.format(remainingBalanceOwed.multiply(negOne))) +".");
		// ask if the customer is able to pay enough
		System.out.println("\nVerify inputs above & if they are correct, request remaining balance: " + (moneyFormat.format(remainingBalanceOwed.multiply(negOne))) + ". \nIf these values ARE NOT correct, submit amounts again by entering \"Retry\" or \"r\".\nIf the customer can provide the remaining balance, enter \"Yes\" or \"y\".\nOtherwise, enter \"No\" or \"n\".");
		// assign response to a String
		String debtPromptResponse = userInput.next();
		// clear the scanner
		userInput.nextLine();
		// switch on response
		switch(debtPromptResponse) {
			// cases for yes or retry
		case "YES":
		case "yes":
		case "Y":
		case "y":
		case "RETRY":
		case "retry":
		case "R":
		case "r":
			// invoke customerPurchaseRequest()
			customerPurchaseRequest();
			// break
			break;
		// cases for no
		case "NO":
		case "No":
		case "N":
		case "n":
			// sysout please return money tendered by customer and re-stock the item(s)
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("Return money tendered by customer and restock the item(s).");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			// invoke the option to quit or continue method
			optionToQuitOrContinue();
			// break
			break;
		// default
		default:
			// sysout unrecognized entry, please start over
			System.out.println("Unrecognized entry. ");
			// invoke the customerPurchaseRequest method 
			optionToQuitOrContinue();
		}
	}
	
	public static void exactChange() {
		System.out.println("\nThe balance is paid in full!\n");
		optionToQuitOrContinue();
	}
		
	// method: customerChangeCalculator(double changeForCustomer)
	public static void customerChangeCalculator(BigDecimal changeForCustomerTotal) {	
		/* **** create BigDecimals for each whole-number piece of currency *** */
		BigDecimal twentyDB = BigDecimal.valueOf(20.00);
		BigDecimal tenDB = BigDecimal.valueOf(10.00);
		BigDecimal fiveDB = BigDecimal.valueOf(5.00);
		BigDecimal oneDB = BigDecimal.valueOf(1.00);
		
		// Create BigDecimals for coins
		BigDecimal quarter = BigDecimal.valueOf(.25);
		BigDecimal dime = BigDecimal.valueOf(.10);
		BigDecimal nickel = BigDecimal.valueOf(.05);
		BigDecimal penny = BigDecimal.valueOf(.01);
				
		// create counters for each currency
		int counterTwenty = 0;
		int counterTen = 0;
		int counterFive = 0;
		int counterOne = 0;
		int counterQuarter = 0;
		int counterDime = 0;
		int counterNickel = 0;
		int counterPenny = 0;
		
		// double assigned to parameter
		BigDecimal changeTarget = changeForCustomerTotal;
		// convert zero double to a Big Decimal
		BigDecimal changeBuilder = BigDecimal.valueOf(0.00);
		
		// while loop so long as the double assigned to zero does not equal the double assigned to the parameter
		while (changeBuilder.compareTo(changeTarget) == -1) {
			// if zero double + 20 is less than changeOwed
			if (changeBuilder.add(twentyDB).compareTo(changeTarget) <= 0) {
				// zero double += 20
				changeBuilder = changeBuilder.add(twentyDB);
				// 20 counter++
				counterTwenty++;
				// otherwise if zero double + 10 is less than changeOwed
			} else if (changeBuilder.add(tenDB).compareTo(changeTarget) <= 0) {
				// zero double += 10
				changeBuilder = changeBuilder.add(tenDB);
				// 10 counter++
				counterTen++;
				// otherwise if zero double + 5 is less than changeOwed
			} else if (changeBuilder.add(fiveDB).compareTo(changeTarget) <= 0) {
				// zero double += 5
				changeBuilder = changeBuilder.add(fiveDB);
				// 5 counter++
				counterFive++;
				// otherwise if zero double + 1 is less than changeOwed
			} else if (changeBuilder.add(oneDB).compareTo(changeTarget) <= 0) {
				// zero double += 1
				changeBuilder = changeBuilder.add(oneDB);
				// 1 counter++
				counterOne++;
				// otherwise if zero double + .25 is less than changeOwed
			} else if (changeBuilder.add(quarter).compareTo(changeTarget) <= 0) {
				// zero double += .25
				changeBuilder = changeBuilder.add(quarter);
				// .25 counter++
				counterQuarter++;
				// otherwise if zero double + .10 is less than changeOwed
			} else if (changeBuilder.add(dime).compareTo(changeTarget) <= 0) {
				// zero double += .10
				changeBuilder = changeBuilder.add(dime);
				// .10 counter++
				counterDime++;
				// otherwise if zero double + .05 is less than changeOwed
			} else if (changeBuilder.add(nickel).compareTo(changeTarget) <= 0) {
				// zero double += .05
				changeBuilder = changeBuilder.add(nickel);
				// .05 counter++
				counterNickel++;
				// otherwise if zero double + .01 is less than changeOwed
			} else if (changeBuilder.add(penny).compareTo(changeTarget) <= 0) {
				// zero double += .01
				changeBuilder = changeBuilder.add(penny);
				// .01 counter++
				counterPenny++;
			}
		}

		// invoke method changeForCustomerMessage(counter20, counter10, counter5, counter1, counter25c, counter10c, counter5c, counter1c)
		changeForCustomerMessage(counterTwenty, counterTen, counterFive, counterOne, counterQuarter, counterDime, counterNickel, counterPenny);
	}
	
	
	// method: changeForCustomerMessage(int bill20, int bill10, int bill5, int bill1, int cent25, int cent10, int cent5, int cent1)
	public static void changeForCustomerMessage(int bill20, int bill10, int bill5, int bill1, int cent25, int cent10, int cent5, int cent1) {
		// assign ints to each parameter
		int TwntyDB = bill20;
		int tenDB = bill10;
		int fiveDB = bill5;
		int oneDB = bill1;
		int quarter = cent25;
		int dime = cent10;
		int nickel = cent5;
		int penny = cent1;

		// set an unassigned String changeOutput
		String emptyStr = "";
		// if the int for 20 is greater than 0
		if (TwntyDB == 1) {
			//changerOutput.concat(int 20 + string 20 denomination + ", "
			emptyStr += TwntyDB + " twenty dollar bill, ";
		} else if (TwntyDB > 1) {
			emptyStr += TwntyDB + " twenty dollar bills, ";
		}
		// if the int for 10 is greater than 0
		if (tenDB == 1) {
			//changerOutput.concat(int 10 + string 10 denomination + ", "
			emptyStr += tenDB + " ten dollar bill, ";
		} else if (tenDB > 1) {
			emptyStr += tenDB + " ten dollar bills, ";
		}
		// if the int for 5 is greater than 0
		if (fiveDB == 1) {
			// changerOutput.concat(int 5 + string 5 denomination + ", "
			emptyStr += fiveDB + " five dollar bill, ";
		} else if (fiveDB > 1) {
			emptyStr += fiveDB + " five dollar bills, ";
		}
		// if the int for 1 is greater than 0
		if (oneDB == 1) {
			// changerOutput.concat(int 1 + string 1 denomination + ", "
			emptyStr += oneDB + " one dollar bill, ";
		} else if (oneDB > 1) {
			emptyStr += oneDB + " one dollar bills, ";
		}
		// if the int for 25c is greater than 0
		if (quarter == 1) {
			// changerOutput.concat(int 25c + string 25c denomination + ", "
			emptyStr += quarter + " quarter, ";
		} else if (quarter > 1) {
			emptyStr += quarter + " quarters, ";
		}
		// if the int for 10c is greater than 0
		if (dime == 1) {
			// changerOutput.concat(int 10c + string 10c denomination + ", "
			emptyStr += dime + " dime, ";
		} else if (dime > 1) {
			emptyStr += dime + " dimes, ";
		}
		// if the int for 5c is greater than 0
		if (nickel == 1) {
			// changerOutput.concat(int 5c + string 5c denomination + ", "
			emptyStr += nickel + " nickel, ";
		} else if (nickel > 1) {
			emptyStr += nickel + " nickels, ";
		}
		// if the int for 1c is greater than 0
		if (penny == 1) {
			// changerOutput.concat(int 1c + string 1c denomination + ", " <- COMMA REQUIRED...
			emptyStr += penny + " penny, ";
		} else if (penny > 1) {
			emptyStr += penny + " pennies, ";
		}
		// set string var to changeOutput using .substring to remove the last character of the string.
		String result = emptyStr.substring(0, emptyStr.length() -2);
		// concat "." to the string var above
		result += ".";
		// sysout the new string var
		System.out.println("\n" + result);
		// invoke method optionToQuitOrContinue()
		optionToQuitOrContinue();
	}
	
	//method: optionToQuitOrContinue()
	public static void optionToQuitOrContinue() {
		// sysout a series of asterisks (user readability)
		System.out.println("\n***********************************************");
		// sysout a question to ask user if they would like to do another MakeChange request or QUIT
		System.out.println("Continue or Quit? -> Please enter \"Y\" or \"N\".");
		// sysout same series of asterisks (user readability)
		System.out.println("***********************************************");
		// save user response to a string var		
		String userContOrQuit = userInput.next();
		// switch
		switch(userContOrQuit) {
			// cases for continue
		case "Continue":
		case "continue":
		case "CONTINUE":
		case "C":
		case "c":
		case "Y":
		case "y":
		case "YES":
		case "Yes":
		case "yes":
				// invoke customerPurchaseRequest()
			customerPurchaseRequest();
			//break not needed, entered for good habits
			break;
			// cases for QUIT
		case "N":
		case "n":
		case "NO":
		case "No":
		case "no":
		case "QUIT":
		case "Quit":
		case "Q":
		case "q":
		case "Exit":
		case "EXIT":
		case "exit":
			// return; (sends program back to main for the thank you sysout and ends the program)
			return;
		// default
		default:
			// sysout unrecognized entry, please start over
			System.out.println("Unrecognized entry. ");
			// invoke the customerPurchaseRequest method 
			optionToQuitOrContinue();
		}
	}
	
}
