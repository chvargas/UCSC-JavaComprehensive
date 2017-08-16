/**	
	Name: 		    Christian Vargas
	Date: 	   		AUG/01/2017
	Instructor:  	Bineet Sharma
	University: 	UCSC Silicon Valley Extension
	
	Description:	This interface is a collection of abstract methods which ensures that all the 
					methods that contain this class are declared previously in the class
					that implements them.
					
					* public abstract double deposit(double amount);
					* public abstract double withdraw(double amount);
					* public abstract void addInterest();
					* public abstract void deductFee();
					* public abstract double getFees();
					* public abstract double getInterestPayment();
*/


public interface IAccount 
{
	public abstract double deposit(double amount);
	
	public abstract double withdraw(double amount);
	
	public abstract void addInterest();
	
	public abstract void deductFee();
	
	public abstract double getFees();
	
	public abstract double getInterestPayment();
	
}