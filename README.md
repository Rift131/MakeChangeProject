# MakeChangeProject
**Brought to you by many Google searches**
## Description
This program acts as a prompter for someone working a cashier. If the money provided by a customer results, when compared to the total bill for purchases, results in change, this program will tell the cashier how many of each currency to give to the customer from largest denomination to smallest. If the customer does not provide enough money (or perhaps the cashier accidently input incorrect numbers) the program will give the balance still owed. Then the cashier will be prompted to review their inputs for accuracy and type a command to try again if needed or, if the values are correct, have the cashier enter if the customer is able to pay the remaining balance or not. If the customer can provide the remaining balance then the program will begin again and have the cashier enter the new values. If the customer cannot provide the remaining balance, the cashier will be prompted to return the money to the customer and restock the item(s). After each transaction, the user will be prompted if they would like to continue or quit the program. 
## Technologies Used
 Java
## What I Learned
BigDecimal is the key to working with decimal place values in Java. Since double variables are translated to binary, the decimal will not stay contained to two places. The BigDecimal utility is the go-to when working with money in Java. BigDecimal brings with it a totally new way of presenting math to Java. 

Another good take-away or practice was breaking the code into as many methods as possible. By using "sysout" this made tracking down where bugs were extremely rapid and allowed me to Google the right questions.  
