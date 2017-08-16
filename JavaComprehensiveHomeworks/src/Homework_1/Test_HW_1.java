package Homework_1;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Test_HW_1 {
	
	public static void excercise_1_1() {
		
		// Create a Scanner object
		Scanner sc = new Scanner(System.in);
		 
		// Display Welcome Message
		System.out.println("Welcome to the Area and Perimeter Calculator");
		 
		// Declare loop control variable
		String continueLoop;
		 
		// Create Control Loop
		do{
		System.out.println();					// Create a blank line
		
		System.out.print("Enter length: ");		// Prompt for length
		double length = sc.nextDouble();		// Declare and set value length variable
		
		System.out.print("Enter width: ");		// Prompt for width
		double width = sc.nextDouble();			// Declare and set value width variable
		
		double area = length * width;					// Declare and calculate area 
		double perimeter = (2 * width) + (2 * length);	// Declare and calculate perimeter 
		 
		// Display area and perimeter to user
		System.out.print("Area: " + area);
		System.out.println();
		System.out.println("Perimeter " + perimeter);
		 
		// Create a blank line
		System.out.println();
		// Prompt for continue
		System.out.print("Continue? (y/n): ");
		System.out.println(); 
		
		// Set value for loop control variable
		continueLoop = sc.next();
		 
		}
		// Continuation clause
		while(continueLoop.equalsIgnoreCase("Y"));
		
		sc.close();
	
	}

	public static void excercise_1_2(){
		
		// Create a Scanner object
		Scanner sc = new Scanner(System.in);
		 
		// Display Welcome Message
		System.out.println("Welcome to the Letter grade converter");
		 
		// Declare loop control variable
		String continueLoop;
		 
		// Create Control Loop
		do{
		System.out.println();					// Create a blank line
		
		System.out.print("Enter numerical grade: ");		// Prompt for numerical grade
		double numGrade = sc.nextDouble();		// Declare and set value length variable
		
		char grade;
		
		if(numGrade >= 88 && numGrade <=100){
            grade = 'A'; }
        else if(numGrade >=80 && numGrade <= 87){
            grade = 'B'; }
        else if(numGrade >= 67 && numGrade <= 79){
            grade = 'C'; }
        else if(numGrade >=60 && numGrade <=66){
            grade = 'D'; }
        else {
            grade = 'F'; }
		
		//Printing letter grade
		System.out.println("Letter Grade : " + grade);
		
		// Prompt for continue
		System.out.println();
		System.out.print("Continue? (y/n): ");
		System.out.println();
		
		// Set value for loop control variable
		continueLoop = sc.next();
		
		}
		// Continuation clause
		while(continueLoop.equalsIgnoreCase("Y"));
		
		sc.close();
	}
	
	public static void excercise_1_3(){
		
		// Create a Scanner object
		Scanner sc = new Scanner(System.in);
		 
		// Display Welcome Message
		System.out.println("Welcome to temperature converter");
		 
		// Declare loop control variable
		String continueLoop;
		 
		// Create Control Loop
		do{
		System.out.println();					// Create a blank line
		
		System.out.print("Enter degrees in Fahrenheit : ");		// Prompt for Fahrenheit degrees
		double userFahrenheitDegrees = sc.nextDouble();		// Declare and set value length variable

		DecimalFormat df2 = new DecimalFormat(".##");
		
	    // Convert Fahrenheit to Celsius
	    double celsius = (5.0 / 9) * (userFahrenheitDegrees - 32);
	    System.out.println(userFahrenheitDegrees + " Fahrenheit degrees" +" is " + 
	      df2.format(celsius) + " in Celsius");  

		// Prompt for continue
		System.out.println();
		System.out.print("Continue? (y/n): ");
		System.out.println();
		
		// Set value for loop control variable
		continueLoop = sc.next();
		
		}
		// Continuation clause
		while(continueLoop.equalsIgnoreCase("Y"));
		
		sc.close();
	}

	public static void excercise_1_4(){
		
		// Create a Scanner object
		Scanner sc = new Scanner(System.in);
		 
		// Display Welcome Message
		System.out.println("Welcome to the travel time calculator ");
		 
		// Declare loop control variable
		String continueLoop;
		 
		// Create Control Loop
		do{
		System.out.println();							// Create a blank line
		
		System.out.print("Enter Miles : ");				// Prompt user enter Miles
		double userMiles = sc.nextDouble();		


		System.out.print("Enter Miles per hour: ");		// Prompt user enter MilesPerHour
		double userMilesPerHour = sc.nextDouble();		

		double totalSeconds = ( (userMiles / userMilesPerHour)*60 ) *60 ;
		double totalMinutes = totalSeconds / 60 ;
		double restoMinutes = totalMinutes % 60 ; 
	    
	    double totalHours = (totalMinutes - restoMinutes ) /60 ; 
	    
	  
	    System.out.println("total hours : " + totalHours );
	    System.out.println("Total Minutes : " + restoMinutes);
	    
		// Prompt for continue
		System.out.println();
		System.out.print("Continue? (y/n): ");
		System.out.println();
		
		// Set value for loop control variable
		continueLoop = sc.next();
		
		}
		// Continuation clause
		while(continueLoop.equalsIgnoreCase("Y"));
		sc.close();
	}

	public static void excercise_1_5(){
		
		// Create a Scanner object
		Scanner sc = new Scanner(System.in);
		 
		// Display Welcome Message
		System.out.println("Welcome to the Change Calculator ");
		 
		// Declare loop control variable
		String continueLoop;
		 
		// Create Control Loop
		do{
		System.out.println();			// Create a blank line
		
		System.out.print("Enter a number of cents (0-99) : ");	// Prompt user enter Miles
	
		double numberOfCents = sc.nextDouble();		
		int quarters = Math.round((int)numberOfCents/25);
	
		numberOfCents=numberOfCents%25;
		int dimes = Math.round((int)numberOfCents/10);
	    
		numberOfCents=numberOfCents%10;
	    int nickels = Math.round((int)numberOfCents/5);
	    
	    numberOfCents=numberOfCents%5;
	    int pennies = Math.round((int)numberOfCents/1);
	    
	    System.out.println("Quarters : " + quarters);
	    System.out.println("Dimes : " + dimes);
	    System.out.println("Nickels : " + nickels);
	    System.out.println("Pennies : " + pennies);
	    
	    
		// Prompt for continue
		System.out.println();
		System.out.print("Continue? (y/n): ");
		System.out.println();
		
		// Set value for loop control variable
		continueLoop = sc.next();
		
		}
		// Continuation clause
		while(continueLoop.equalsIgnoreCase("Y"));
		sc.close();
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("--------Homework 1 Java Programming, Comprehensive----------");
		System.out.println("------------------------------------------------------------");
		excercise_1_1();
		System.out.println("------------------------------------------------------------");
		excercise_1_2();
		System.out.println("------------------------------------------------------------");
		excercise_1_3();
		System.out.println("------------------------------------------------------------");
		excercise_1_4();
		System.out.println("------------------------------------------------------------");
		excercise_1_5();
		System.out.println("@Christian Vargas, UCSC Sillicon Valley Extension");
		

	}

}
