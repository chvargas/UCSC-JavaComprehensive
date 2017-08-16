/**	
	Name: 		    Christian Vargas
	Date: 	   		AUG/01/2017
	Instructor:  	Bineet Sharma
	University: 	UCSC Silicon Valley Extension
	
	Description:	Account is a abstract class that implements all IAccount methods 
					except deductFee and addInterest.        
*/

import java.text.NumberFormat;

/** Abstract class (Account) implementing Account interface (IAccount)*/
public abstract class Account implements IAccount
{
	private double balance;
	private boolean checkBoolean = true;
	
	/** Default constructor that will set starting balance to 1000*/
	public Account()
	{
		balance = 1000.0;		
	}

	/** This method will set the balance and will be called when the fee is being deducted,
	 * @param balance
	 */
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	/** This method will update balance when money is being deposited in the user's account	 */
	public double deposit(double amount)
	{
		balance += amount;
		return balance;
	}
	
	/** This method will update balance when a withdrawn operation is being executed. 
	 * It does not allow for any overdraft
	 */
	public double withdraw(double amount)
	{	
		if(balance - amount < minimumBalance())
		{
			System.out.println("Overdraft is not allowed.\n"
					+ "You need to maintain a minimum balance of $1 for "
					+ "Checking and $0 for savings account\n ");
		}
		else
		{
			balance -= amount;
		}
		return balance;
	}
	
	/** Method that will get current balance.*/	
	public double getBalance()
	{
		return balance;
	}
	
	/** This method will be called when the user finishes all operations.  
	 * Ensuring fee deduction and interest addition to the final amount. */
	public void endOperation()
	{
		//If statement that check fee deduction and interest addition.
		if(checkBoolean)
		{
			deductFee();
			addInterest();
			checkBoolean = false;
		}
	}
	
	/** Method which is used to format balance amount.*/
	public String getFormattedBalance()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(balance);
	}
	
	/** This are abstract methods to perform the following:
	 	* 	add interest 
	 	* 	deduct fees 
	 	* 	get fees
	 	*  get earned interest 
	 	*  get formatted values
	 	*  get the minimum required value to maintain in checking and Saving Accounts. 
	These classes have been defined in the child classes (CheckingAccount and SavingsAccount)
	*/
	
	public abstract void addInterest();
	public abstract void deductFee();
	public abstract double getFees();
	public abstract double getInterestPayment();
	public abstract String getFormattedFees();
	public abstract String getFormattedInterestPayment();
	public abstract double minimumBalance();
}