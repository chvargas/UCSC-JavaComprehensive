package Homework_4;
public class Customer extends Person {
	
	String customerNumber;
	
	public Customer()
	{
		super();
	}
	
	public void setCustomerNumber(String custNumber)
	{
		this.customerNumber = custNumber;
	}
	
	public String getCustomerNumber()
	{
		return customerNumber;
	}
	
	@Override
	public String getDisplayText()
	{
		return super.toString()+
				"Customer Number: "+getCustomerNumber()+"\n";
	}
}