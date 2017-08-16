/**	
	Name: 		    Christian Vargas
	Date: 	   		AUG/01/2017
	Instructor:  	Bineet Sharma
	University: 	UCSC Silicon Valley Extension
	
	Description:	This class is child of Account class, this class is used only for the Saving
					Accounts. 
					
					* Only Saving Accounts are allowed to pay an interest rate that will 
						be defined, calculated and added in this class. (1%) Monthly
					* This class implements a method that allows updating the balance after being 
						applied interest rate to the total amount.
					* The methods deductFee(), getFees() and getFormattedFees() are called
						because of the inherited necessity of the Parent class.
					* All the amounts that are used in this class will be formatted as currency 
						to printing purposes. 
*/

import java.text.NumberFormat;

public class SavingsAccount extends Account 
{
	
	private final double monthlyInterestRate = 1.0;
	private double interestPayment;
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	public SavingsAccount()
	{
		super();
		interestPayment = 0.0;
	}
	
	/** This method will calculate interest payment and the balance subsequently, 
	 * it will call setBalance() Method of a parent class to update their balance.
	 */
	public void addInterest()
	{
		//Calculating Interest Payment using Monthly interest Rate Variable that was 
		//previously established
		interestPayment = (monthlyInterestRate/100) * (super.getBalance()); 
		
		//Setting and calculating FinalBalance, calling getBalance method from parent 
		//class and adding it interest payment
		double finalBalanceAfterInterest = super.getBalance() + interestPayment;
		
		//Setting finalBalance in parent Account class
		super.setBalance(finalBalanceAfterInterest);
	}
	
	/** This method will return the calculated interest payment since savings Account 
	 * doesn't have one.This is necessary because SavingsAccount Class inherited the method
	 * Account.getInterestPayment() from the Parent Class "Account"
	 * */
	public double  getInterestPayment()
	{
		return interestPayment;
	}
	
	/** This method will return in a formatted way the Interest payment that was calculated.*/
	public String getFormattedInterestPayment()
	{
		return currency.format(getInterestPayment());
	}
	
	/** Savings account doesn't charge fee to the user, however is necessary deduct 0 and set the
	 *  balance method which was inherited from the the Parent Class "Account.
	 */
	public void deductFee()
	{
		super.setBalance(super.getBalance() - 0);	
	}
	
	/** This method will return the fee to 0 since savings Account doesn't have one. 
	 * This is necessary because SavingsAccount Class inherited the method
	 * Account.get Fees() from the Parent Class "Account"
	 */
	public double getFees()
	{
		return 0;
	}
	
	/** This method will return the formatted fee to 0 since savings Account doesn't have one. 
	 * This is necessary because SavingsAccount Class inherited the method
	 * Account.getFormattedFees() from the Parent Class "Account"
	 */
	public String getFormattedFees()
	{
		return getFees() + "" ;
	}
	
	/** This method will return the minimum balance established by the Bank which is 0	
	 */
	public double minimumBalance()
	{
		return 0;
	}
	
}