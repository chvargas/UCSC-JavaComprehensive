/**	
	Name: 		    Christian Vargas
	Date: 	   		AUG/01/2017
	Instructor:  	Bineet Sharma
	University: 	UCSC Silicon Valley Extension
	
	Description:	This class is child of Account class, this class is used only for the Checking
					Accounts. 
					
					* This class will check a  minimum balance of $1
					* This class will deduct a ($1) fee for the checking Accounts at the end of 
					 	the transactions.
					* This class implements a method that allows updating the balance after being 
						deducted fee from the total amount.
					* The methods getInterestPayment(), getFormattedInterestPayment() and addInterest() are called
						because of the inherited necessity of the Parent class.
					* All the amounts that are used in this class will be formatted as currency 
						to printing purposes. 
*/

import java.text.NumberFormat;

/**Child class CheckingAccount extending Account which is now its parent class
 * 
 * @author ChristianVargas
 *
 */
public class CheckingAccount extends Account {
	
//Instance variables
	
	//checking fee has been defined for the bank as $1,  
	private final double CHECKING_FEE = 1.0;
	
	//Variable which will generate final balance in checking accounts
	private double balanceAfterFeeDeduction;
	
	// Creation of a variable fee
	private double fee;
	
	/**Default constructor*/
	public CheckingAccount()
	{
		super();
		balanceAfterFeeDeduction = 0.0;
	}
	
	/**This method returns the fee to be deducted */
	public double getFees()
	{
		return fee;
	}
	
	/**This method returns the formatted fee */
	public String getFormattedFees()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(getFees());
	}
	
	/** This method will return 0 since interest rate doesn't apply to Checking Account.
	 *  Due to this method is an abstract method of the parent class, must be defined here. */
	public double getInterestPayment()
	{
		return 0;
	}
	
	/** This method will format the output result returned by the Method getInterestpayment() 
	 *  Due to this method is an abstract method of the parent class, must be defined here. */
	public String getFormattedInterestPayment()
	{
		return getInterestPayment()+"";
	}
	
	/** This method will return 0 since interest rate doesn't apply to Checking Account.
	 *  Due to this method is an abstract method of the parent class, must be defined here. */
	public void addInterest()
	{
		return;
	}
	
	/**This method will return 1 which is the minimum required balance for Checking Accounts. */
	public double minimumBalance()
	{
		return 1;
	}
	
	/** This method will perform the Math operation deducting the fee and subsequently calculating 
	 * the final balance calling the method of the parent class. */
	public void deductFee()
	{
		fee = CHECKING_FEE;
		balanceAfterFeeDeduction = super.getBalance() - fee;
		super.setBalance(balanceAfterFeeDeduction); 
	}
	
}