/**	
	Name: 		    Christian Vargas
	Date: 	   		AUG/01/2017
	Instructor:  	Bineet Sharma
	University: 	UCSC Silicon Valley Extension
	
	Description:	This class validates that user input has been correct.
	
	Methods: 		* getDouble(Scanner sc, String prompt)
					* getChoiceString(Scanner sc,String prompt,String s1,String s2)
*/

import java.util.Scanner;

public class Validator
{
	/**This method will validate the choice entered by the user using a double (decimal)
	 * If entered input  was not a double , it will ask again until the input is correct.
	 * @param sc
	 * @param prompt
	 * @return
	 */
	
	public static double getDouble(Scanner sc, String prompt)
	{
		double d = 0; //Initializing variable
		boolean checkBooleanIsDouble = false; //Setting to False boolean variable

		while (checkBooleanIsDouble == false)
		{
			System.out.print(prompt);//will print method text that has been introduced
			
			if (sc.hasNextDouble()) //If statement that checks whether user has entered a double data type
			{
				d = sc.nextDouble(); //Reading from user using Scanner
				checkBooleanIsDouble = true; //Change to true the condition to go out of the loop
			}
			else
			{
            System.out.println("\nError! You have entered an invalid decimal value. \n"
            		+ "Please Try again.");//ask user to re-type correct input
            }
			
			sc.nextLine();  // clean scanner
        }
		return d; //return variable
	}

	
	/**This method will validate the choice entered giving the user two options through a 
	 * question using two string s1 or s2 If entered input  was not either one of them, 
	 * it will ask again until the correct choice.
	 * @param sc
	 * @param prompt
	 * @param s1
	 * @param s2
	 * @return
	 */
	
	public static String getChoiceString(Scanner sc,String prompt,String s1,String s2)
	{
		boolean checkBooleanIsString = false; //Setting to False boolean variable
    	String choice = null; //Initializing variable
    	
    	while(checkBooleanIsString == false)
    	{
    		System.out.print(prompt);//will print method text that has been introduced

    		choice = sc.next();  // Reading from user using Scanner
	        sc.nextLine(); // discard other data entered 
	        
	        if(choice.equalsIgnoreCase(s1) || choice.equalsIgnoreCase(s2))//If statement that checks whether user has entered one of the string previously asked as data type
	        {
	        	checkBooleanIsString = true; //Change to true the condition to go out of the loop
	        }
	        else
	        {
	        	System.out.println("\nError! You have entered an invalid option, \n"
	        			+ "must be '"+s1+"' or '"+s2+"'.Try again\n");
	        }
    	}
        return choice;
	}	
}