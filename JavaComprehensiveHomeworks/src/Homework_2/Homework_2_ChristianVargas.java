package Homework_2;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Homework_2_ChristianVargas {

public static void excercise_2_1() {

		// Create a Scanner object
		Scanner sc = new Scanner(System.in);

		// Display Welcome Message
		System.out.println("Welcome to the Interest Calculator");

		// Declare loop control variable
		String continueLoop;

		// Create Control Loop
		do {
			System.out.println(); // Create a blank line

			System.out.print("Enter loan amount: "); // Prompt for length
			double userLoanAmount = sc.nextDouble(); // Declare and set value
														// loan

			System.out.print("Enter interest rate: "); // Prompt for width
			double userInterestRate = sc.nextDouble(); // Declare and set value
														// Interest Rate
			double totalInterest = userLoanAmount * userInterestRate; // Declare
																		// and
																		// calculate
																		// area

			BigDecimal totalInterestRoundedBD = new BigDecimal(totalInterest);

			String currencyFormat = "$###,###,###.##";
			DecimalFormat dfCurrency = new DecimalFormat(currencyFormat);

			String percentageFormat = "###.##%";
			DecimalFormat dfPercentage = new DecimalFormat(percentageFormat);

			// Printing Loan, Interest Rate and Interest Paid
			System.out.println("Total Loan      : " + "\t" + dfCurrency.format(userLoanAmount));
			System.out.println("Interest Rate   : " + "\t" + dfPercentage.format(userInterestRate));
			System.out.println("Total Interest  : " + "\t" + dfCurrency.format(totalInterestRoundedBD));

			// Create a blank line
			System.out.println();
			// Prompt for continue
			System.out.print("Continue? (y/n): ");
			System.out.println();

			// Set value for loop control variable
			continueLoop = sc.next();

		}
		// Continuation clause
		while (continueLoop.equalsIgnoreCase("Y"));

	}

public static void excercise_2_2() {
		// Welcome the user
		System.out.println("Welcome to the Squares and Cubes table");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		String choice = "y";

		do {
			// Get input from the user
			System.out.print("Enter an integer: ");
			int integer = sc.nextInt();

			// Create a header
			String header = "Number" + "\t" + "Squared" + "\t" + "Cubed" + "\n" + "======" + "\t" + "======" + "\t"
					+ "======";

			System.out.println(header);

			int square = 0;
			int cube = 0;

			String row = "";
			for (int i = 1; i <= integer; i++) {

				square = i * i;
				cube = i * i * i;

				row = i + "       " + square + "       " + cube;
				System.out.println(row);
			}

			// See if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();

		} while (!choice.equalsIgnoreCase("n"));
	}

public static void excercise_2_3() {
	  String choice = "y";
      Scanner sc = new Scanner(System.in);

      System.out.println("Welcome to the Area and Perimeter Calculator");

      while (choice.equalsIgnoreCase("y"))

      {int first=0;
          System.out.println();
          double length = getDoubleWithinRange (sc, "Enter length: ", 0, 1000000);
          double width = getDoubleWithinRange (sc, "Enter width: ", 0, 1000000);
          double area = length * width;
          double perimeter = (2 * length) + (2 * width);
          String results = "Area:\t\t" + area + "\n" + "Perimeter:\t" + perimeter;

          System.out.print(results);

          System.out.println();

          try
          {
              System.out.println();
              System.out.print("Continue? (y/n): ");

              do{
              
            	  if(first==1)
                      System.out.println("Error! Entry must be 'y' or 'n'. Try again.");
                  choice = sc.next();
                  first=1;
                  
               }while(! (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")));
              
              System.out.println();

          }

          catch (NullPointerException e)

          {
              System.out.println("Error! This entry is required. Try again.");
              sc.next();
          }
      }
  }

public static void excercise_2_4() {
	  String choice = "y";
      Scanner sc = new Scanner(System.in);

      System.out.println("Welcome to the Loan Calculator");

      while (choice.equalsIgnoreCase("y"))

      {int first=0;
          System.out.println();
          double userLoanAmount = getDoubleWithinRange (sc, "Enter loan amount: ", 0, 1000000);
          double userYearlyInterestRate = getDoubleWithinRange (sc, "Enter yearly interest rate: ", 0, 20);
          int userNumberOfYears = (int) getDoubleWithinRange (sc, "Enter number of years", 0, 100);

          
          double monthlyInterestRate = userYearlyInterestRate/12/100;
          int months = userNumberOfYears * 12;

          double payment = calculateMonthlyPayment( userLoanAmount, months, monthlyInterestRate);
          
          String currencyFormat = "$###,###,###.##";
          DecimalFormat dfCurrency = new DecimalFormat(currencyFormat);
          
          String percentageFormat = "##.##%";
          DecimalFormat dfPercentage = new DecimalFormat(percentageFormat);

          // Printing Loan, Interest Rate and Interest Paid
          System.out.println("Loan amount : " + "\t" + "\t" + dfCurrency.format(userLoanAmount));
          System.out.println("Yearly Interest Rate : "+ "\t" + "\t" + dfPercentage.format(userYearlyInterestRate));
          System.out.println("Number of Years : "+ "\t" + "\t" + userNumberOfYears);
          System.out.println("Monthly Payment : "+ "\t" + "\t" +dfCurrency.format(payment));
      
          try
          {
              System.out.println();
              System.out.print("Continue? (y/n): ");

              do
              {
            	  if(first==1)
                      System.out.println("Error! Entry must be 'y' or 'n'. Try again.");
                  choice = sc.next();
                  first=1;
                  
               }
              while(! (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")));
              
              System.out.println();

          }

          catch (NullPointerException e)

          {
              System.out.println("Error! This entry is required. Try again.");
              sc.next();
          }
      }
  }

public static double calculateMonthlyPayment(double loanAmount,int months, 
		double monthlyInterestRate){
	
	        double monthlyPayment =
	            loanAmount * monthlyInterestRate/
	            (1 - 1/Math.pow(1 + monthlyInterestRate, months));

	        return monthlyPayment;
}

public static double getDouble(Scanner sc, String prompt){

    double d = 0.0;
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
            sc.nextLine();
        }
    }
    return d;
}

public static double getDoubleWithinRange(Scanner sc, String prompt, double min, double max){

double d = 0.0;
boolean isValid = false;
while (isValid == false)

{
    d = getDouble(sc, prompt);
    if (d<=min)
    {
        System.out.println("Error! Number must be greater than " + min + ".");
    }
    else if (d >= max)
    {
        System.out.println("Error! Number must be less than " + max + ".");
    }
    else
        isValid = true;
}
return d;
}

public static void main(String[] args) {
		System.out.println("--------Homework 2 Java Programming, Comprehensive----------");
		System.out.println("------------------------------------------------------------");
		excercise_2_1();
		System.out.println("------------------------------------------------------------");
		excercise_2_2();
		System.out.println("------------------------------------------------------------");
		excercise_2_3();
		System.out.println("------------------------------------------------------------");
		excercise_2_4();

		System.out.println("@Christian Vargas, UCSC Sillicon Valley Extension");
	}

}
