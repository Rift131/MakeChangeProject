package com.skilldistillery.makechange;

public class MakeChange {
	
	// global scanner
	
	// global formatDecimal

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
		
		// sysout Thank you for using the MakeChange program
		
		// close the scanner
	}
	
	
	//method customerPurchaseRequest()
	
		// ask user for price of item
	
		// assign response value to a double formatted to DecimalFormat
			
		// ask user for the amount tendered by customer
			
			// assign response to a double var formatted to DecimalFormat
			
			// double var that is the delta of amount tendered and amount owed
			
			// if the delta var is less than zero
			
				// invoke method remainingBalance(tendered, price, owed) 
			
				// otherwise
			
				// invoke method customerChangeCalculator(delta var)
	
	
	
	// method: remainingBalance(double tendered, double owed)
	
		// (prompt a message indicating how much more is needed to zero out the balance (delta var * -1)
	
		// ask if the customer is able to pay enough
	
		// assign response to a String
	
		// switch on response
	
			// cases for yes
	
				// invoke customerPurchaseRequest()
	
			// cases for no
	
				// sysout please return money tendered by customer and re-stock the item(s)
	
	
	// method: customerChangeCalculator(double changeForCustomer)
		
		/* **** create doubles for each piece of currency, each formatted to decimalformat *** */
	
		// double assigned to parameter
	
		// double assigned to zero
	
		// double 20
	
	 	// int 20 counter
			
		// 10
	
		// int 10 counter
			
		// double 5
	
		// int 5 counter
			
		// double 1
	
		// int 1 counter
			
		// double .25
	
		// int .25 counter		
			
		// double .10
	
		// int .10 counter
	
		// double .05
	
		// int .05 counter
			
		// double .01
	
		// int .01 counter
	
		// for loop so long as the double assigned to zero does not equal the double assigned to the parameter
	
			// if zero double + 20 is less than changeOwed
	
				// zero double += 20
	
				// 20 counter++
	
				// otherwise if zero double + 10 is less than changeOwed
	
				// zero double += 10
	
				// 10 counter++
	
				// otherwise if zero double + 5 is less than changeOwed
	
				// zero double += 5

				// 5 counter++
	
				// otherwise if zero double + 1 is less than changeOwed
	
				// zero double += 1

				// 1 counter++
	
				// otherwise if zero double + .25 is less than changeOwed
	
				// zero double += .25

				// .25 counter++
	
				// otherwise if zero double + .10 is less than changeOwed
	
				// zero double += .10

				// .10 counter++
	
				// otherwise if zero double + .05 is less than changeOwed
	
				// zero double += .05

				// .05 counter++
	
				// otherwise if zero double + .01 is less than changeOwed
	
				// zero double += .01

				// .01 counter++
	
		// invoke method changeForCustomerMessage(counter20, counter10, counter5, counter1, counter25c, counter10c, counter5c, counter1c)
	
	
	// method: changeForCustomerMessage(int bill20, int bill10, int bill5, int bill1, int cent25, int cent10, int cent5, int cent1)
	
		// assign ints to each parameter
	
		// assign strings to each denomination with if statements to be plural if the int is greater than 1
	
		// set an unassigned String changeOutput
	
		// if the int for 20 is greater than 0
	
			//changerOutput.concat(int 20 + string 20 denomination + ", "
		
		// if the int for 10 is greater than 0
	
			//changerOutput.concat(int 10 + string 10 denomination + ", "
	
		// if the int for 5 is greater than 0
	
			// changerOutput.concat(int 5 + string 5 denomination + ", "
	
		// if the int for 1 is greater than 0
	
			// changerOutput.concat(int 1 + string 1 denomination + ", "
	
		// if the int for 25c is greater than 0
	
			// changerOutput.concat(int 25c + string 25c denomination + ", "
	
		// if the int for 10c is greater than 0
	
			// changerOutput.concat(int 10c + string 10c denomination + ", "
	
		// if the int for 5c is greater than 0
	
			// changerOutput.concat(int 5c + string 5c denomination + ", "
	
		// if the int for 1c is greater than 0
	
			// changerOutput.concat(int 1c + string 1c denomination + ", " <- COMMA REQUIRED...
	
		// set string var to changeOutput using .substring to remove the last character of the string.
	
		// concat "." to the string var above
		
		// sysout the new string var
	
		// invoke method optionToQuitOrContinue()
	
	
	//method: optionToQuitOrContinue()
	
		// sysout a blank line
	
		// sysout a series of asterisks (user readability)
	
		// sysout a question to ask user if they would like to do another MakeChange request or QUIT
	
		//sysout same series of asterisks (user readability)
	
		// save user response to a string var
	
		
	
		// switch
	
			// cases for continue
	
				// invoke customerPurchaseRequest()
	
			// cases for QUIT
	
				// return; (sends program back to main for the thank you sysout and ends the program)
	
	
}
