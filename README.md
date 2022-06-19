# MakeChangeProject

HOW TO RUN: Open the "MakeChange.java" file in an IDE that supports Java and press Command + shift + F11. Follow the prompts that appear in the IDE console or terminal. 

## Description
This program acts as a prompter for someone working a cashier. If the money provided by a customer results, when compared to the total bill for purchases, results in change, this program will tell the cashier how many of each currency to give to the customer from largest denomination to smallest. If the customer does not provide enough money (or perhaps the cashier accidently input incorrect numbers) the program will give the balance still owed. Then the cashier will be prompted to review their inputs for accuracy and type a command to try again if needed or, if the values are correct, have the cashier enter if the customer is able to pay the remaining balance or not. If the customer can provide the remaining balance then the program will begin again and have the cashier enter the new values. If the customer cannot provide the remaining balance, the cashier will be prompted to return the money to the customer and re-stock the item(s). After each transaction, the user will be prompted if they would like to continue or quit the program. 

This program features 3 utilities:
BigDecimal- to ensure proper handling of decimal places and accurate money calculations.
DecimalFormat- to ensure proper monetary formatting is embedded into prompts when not enough money is provided.
Scanner- to allow testing inputs while working in an IDE environment.
## Technologies Used
 Java
## What I Learned
Casting- initially you have to work with doubles due to prompting the user for inputs allowing for less than whole-dollar amounts. This becomes problematic when you need to count up the number of coins required. To escape the unending decimal values when performing math with these values, you have to cast the balance of coins to an int (int remainingBalanceInCoins = (int) nameOfDoubleVariable;). 

Modulo- You can use modulo in the if/else statements used to determine which currency counters to increment (total % 2 == 0). However you also must use an or statement to account for when the currency doesn't produce a remainder of zero but is less than the total (total % 2 == 0 || quarter < total) {quarterCounter++;}.

BigDecimal is one way of working with decimal place values in Java. Since double variables are not base 10, the decimal will not stay contained to two places. The BigDecimal utility is the go-to when working with money in Java. BigDecimal brings with it a totally new way of presenting math to Java. 

Another good take-away or practice was breaking the code into as many methods as possible. By using "sysout" this made tracking down where bugs were located extremely rapid and allowed me to Google the right questions.  
