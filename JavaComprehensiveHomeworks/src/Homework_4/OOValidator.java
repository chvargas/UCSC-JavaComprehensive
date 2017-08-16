package Homework_4;
import java.util.Scanner;

public class OOValidator {
	
	protected Scanner sc;
	
	OOValidator(){
		sc = new Scanner(System.in);
	}
	
	OOValidator(Scanner sc){
		this.sc=sc;
	}
	
	public int getInt(String prompt){
		
        int i = 0; 					// variable that will save user input
        boolean isValid = false;	// setting boolean for the while loop
        while (isValid == false)
        {
            System.out.print(prompt); // prompt user asking info to be enter
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard and eliminate other data entered 
        }
        return i; // return variable
    }

    public int getIntWithinRange(String prompt, int min, int max){
        
    	int i = 0;				// creating variable that will save user input
        boolean isValid = false;// creating boolean that will check while loop 
        
        while (isValid == false)        
        {
            i = getInt(prompt);  //utilize getInt method already written
            
            if (i < min)		// checking minimum range 
                System.out.println(
                    "Error! Number must be greater than " + min + ".");
            
            else if (i > max)	// checking maximum range
                System.out.println(
                    "Error! Number must be less than " + max + ".");
           
            else
                isValid = true; // will change to true the boolean variable created before,
            					// to go out of the while loop. If one of the conditions 
            					// settled before ended as true, it will end out of the loop
        }
        return i;
    }

    public double getDouble(String prompt)
    {
        double d = 0;
        boolean isValid = false;
        
        while (isValid == false)
        {
            System.out.print(prompt);
            
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public double getDoubleWithinRange(String prompt, double min, double max){
        
    	double d = 0;
        boolean isValid = false;
        
        while (isValid == false)
        {
            d = getDouble(prompt);  //use the method already written
            if (d < min)
                System.out.println(
                    "Error! Number must be greater than " + min + ".");
            else if (d > max)
                System.out.println(
                    "Error! Number must be less than " + max + ".");
            else
                isValid = true;
            
        }
        return d;
    }
}