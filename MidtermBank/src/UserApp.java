/**	
	Name: 		    Christian Vargas
	Date: 	   		AUG/01/2017
	Instructor:  	Bineet Sharma
	University: 	UCSC Silicon Valley Extension
	
	Description:	This program has been developed to modernize the banking experience 
					between Bank and Users, by providing to the user an interactive 
					interface which will allow checking accounts from the house comfort.
					
					1. The program will start with a prompt showing starting balance.
					2. Then will ask the user whether he wants to withdraw or 
						deposit money typing (w) or (d) respectively.
					3. Then will ask the user to chose between Savings or Current
						Account typing (s) or (c) respectively.
					4. Then will ask to enter the desired amount to the user.
					5. Then will ask the user if he wants to continue typing 
						(y)/(n) respectively.
					6. If user's decision was (y) the program will go back to point 2.
					7. If user's decision was (n) the program will end and show:
					 		* Monthly payment 
					 		* Fees 
					 		* Final balances in both accounts
					 		
	Constraints:	1. The program will check user input continuously. If user gave wrong 
						input or tries to do not enter anything the program will give a 
						chance to re-type correct choice.
*/

import java.util.Scanner;

public class UserApp {
	
	// Creating Checking Account and Savings Account reference to objects (Polymorphism)
	static Account current = new CheckingAccount();
	static Account savings = new SavingsAccount();
	
	/**This is the main method, which executed the main program calling all different methods
	 * from multiple classes : Account, CheckingAccount, IAccount, SavingsAccount and Validator
	 * @param args */
	public static void main(String[] args) 
	{
		// This method will execute the user transactions
		
		executeTransactions();

		// When the user input is (n) all transactions will have finalized.
		// therefore, fee will be deducted and the interest will be added
		// to the user balance in both accounts.
		
		current.endOperation();
		savings.endOperation();
				
		//These methods will print monthly fees, interest rate and the final balance.
		
		printFeeAndInterest();
		printFinalBalance();
	}
	
	/**This method will execute the transactions setting a string with a default (y) value
	 * which allow going inside the while loop to subsequently check user inputs calling the 
	 * Validator class, who previously have checked the correct user input.*/
	public static void executeTransactions()
	{
		//Initializing user's choice to "y"
		String choice = "y";
		
		//Initializing amount with a default value of 0
		double amount = 0;
		
		//Using Scanner to ask user input
		Scanner sc = new Scanner(System.in);
				
		//Printing Welcome and Starting Balances prompt to the user. 
		System.out.println("Welcome to the Account application\n");
		System.out.println("Starting Balances"); 
			
		//Showing initial balance in both accounts
		System.out.println("Checking:  " + current.getFormattedBalance()+"\n"+
		                   "Savings:   " + savings.getFormattedBalance());
		
		System.out.println("\nEnter the transactions for the month\n");
		
		//while loop that will check user input (y) or (n), it will be true when 
		//user input is (y) and will continue execution until user final decision is (n).
		
		while(choice.equalsIgnoreCase("y"))
		{
			//User is being asked to give choice withdraw (w) or deposit (d). 
			//User's choice will be validated in Validator class. 
			//getChoiceString Method will check if was typed the correct string.
			
			String withdrawOrDepositUserChoice = Validator.getChoiceString
					(sc, "Withdrawal or deposit? (w/d): ", "w", "d");
			
			//User is being asked to give choice current (c) or savings (s) Accounts. 
			//User's choice will be validated in Validator class. 
			//getChoiceString Method will check if was typed the correct string.
			
			String acountTypeUserChoice = Validator.getChoiceString
					(sc, "Checking or savings? (c/s): ", "c", "s");
			
			//User is being asked to enter the withdraw or deposit amount.
			//getDouble Method that will check if was typed the correct double data type.
			
			amount = Validator.getDouble(sc, "Please type the desired Amount?: ");
			
			System.out.println();
			
			//This If statement will check if user's choice was c or C, 
			//is user entered this letter, the if condition will be true and 
			//will execute the operations on Checking or Current account
			
			if(acountTypeUserChoice.equalsIgnoreCase("c"))
			{	
				//This If statement will check if user's choice was w or W, 
				//is user entered this letter, the if condition will be true and 
				//will execute the operations on Checking or Current account

				if(withdrawOrDepositUserChoice.equalsIgnoreCase("w"))
				{
					//Will deduct the balance amount with a withdrawal operation on
					//current account.
					current.withdraw(amount);
				}
				else
				{	
					//Will add  the balance amount with a deposit operation.
					//on current account. 
					current.deposit(amount);
				}
			}
			
			//If user's choice was s or S, then will execute the operations 
			//on savings account
			
			else
			{
				//This If statement will check if user's choice was w or W, 
				//is user entered this letter, the if condition will be true and 
				//will execute the operations on Checking or Current account
				
				if(withdrawOrDepositUserChoice.equalsIgnoreCase("w"))
				{
					//Will deduct the balance amount with a withdrawal operation on
					//Savings Account
					savings.withdraw(amount);
				}
				else
				{
					//Will add  the balance amount with a deposit operation.
					//on current account. 
					savings.deposit(amount);
				}
			}
			
			//The program will ask the user if he wants to continue or not (y)/(n). 
			//User choice will be validated in Validator class, 
			//checking whether has been typed the correct string.
			
			choice = Validator.getChoiceString(sc, "Continue? (y/n): ", "y", "n");
			System.out.println();
		}
}
	
	/**This method will print the fees and interest payment with a currency format.*/
	public static void printFeeAndInterest()
	{
		System.out.println("\nMonthly Payments and Fees");
		System.out.println("Checking fee:              " + current.getFormattedFees() +"\n"+
				           "Savings interest payment:  " + savings.getFormattedInterestPayment());
	}
	
	/**This method will print final balance in both the accounts.*/
	public static void printFinalBalance()
	{
		System.out.println("\nFinal Balances\n"
							+ "Checking: " + current.getFormattedBalance() + "\n" +
							  "Savings:  " + savings.getFormattedBalance());
	}
}