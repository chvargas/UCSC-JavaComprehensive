
package JavaComprehensiveThreadRunners;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Validator.
 *
 * @author Christian Vargas
 */

class Validator 
{
	
	/** The sc. */
	private static Scanner sc = new Scanner(System.in);
	
   /**
    * Will repeat if statement until a valid string is given.
    * @param prompt			String prompt asking user to enter data
    * @return				Validated string 
    */	

	public static String getString (String prompt)
	{
		String s;
		
		while (true)
		{
			System.out.print(prompt); 	//Printing prompt message
			
			if (sc.hasNextLine()) 		//Checking whether the string has next line or it is blank.
			{		
				s = sc.nextLine();
				
				if (s.isEmpty())		//If string is empty will ask again user to enter a valid input
				{
					System.out.println("Invalid input. Try again.\n");
				}
				else
					return s;			//Will store user's input as "s" as a valid string
			}
		}
	}
	
   /**
    * Will repeat if statement until a valid integer is is given.
    *
    * @param prompt 	A prompt asking user to enter data
    * @param min the min
    * @param max the max
    * @return 		Validated integer
    */	
	
	public static int getIntRange (String prompt , int min , int max)
	{
		int value;
		while (true)
		{
			System.out.print(prompt); 	//Printing prompt message
			
			if (sc.hasNextInt())		//Checking whether the number is integer.
			{
				value = sc.nextInt();
				
				if (value < min || value > max)	//If number is less-than min value or is greater than max value 
				{
					sc.nextLine();
					System.out.println("Invalid input. Try again.\n");  //If integer doesn't satisfy min and max 
																		//values will repeat loop asking 
																		//to enter valid numbers
				}
				else
				{
					sc.nextLine();
					return value;		//Will store user's input as "value" a valid integer
				}
			}
			else
			{
				sc.nextLine();
				System.out.println("Invalid input. Try again.\n");
			}
				
		}
	}
}