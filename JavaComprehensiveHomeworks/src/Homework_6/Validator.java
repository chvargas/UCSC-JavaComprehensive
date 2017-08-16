package Homework_6;

import java.util.Scanner;

public class Validator {
	private static Scanner sc = new Scanner(System.in);

	public static int getChoice() {
		
		boolean isValid = false;
		int choice = 0;
		
		do {
			try 
			{
				choice = Integer.parseInt(sc.nextLine());
				isValid = true;
				break;
			} catch (NumberFormatException e) 
			{
				System.out.println("Please enter an integer between 1 and 3 to continue");
				isValid = false;
			}
		} while (!isValid);
		return choice;
	}

	public static int verifyChoice(String prompt) {
		
		int choice = 0;
		boolean isValid = false;
		do {
			System.out.println(prompt);
			choice = getChoice();
			switch (choice) {

			case 1:
				isValid = true;
				break;
			case 2:
				isValid = true;
				break;
			case 3:
				isValid = true;
				break;
			default:
				isValid = false;
				System.out.println("Please enter an integer between 1 and 3 to continue\n");
				break;
			}
		} while (!isValid);
		return choice;
	}
}