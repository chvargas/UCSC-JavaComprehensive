package Homework_6;

import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);

			CountriesTextFile.createFile();

			System.out.println("Welcome to the Countries Maintenance Application!\n");

			int userChoice = Validator.verifyChoice("1 - See the list of countries\n2 - Add a country\n3 - Exit\n\nEnter menu number [1/2/3] : ");

			while (userChoice != 3) 
			{

				if (userChoice == 1) 
				{
					CountriesTextFile.list();
					System.out.println();
				}
				if (userChoice == 2) 
				{
					System.out.println("Enter a country: ");
					String country = sc.nextLine();
					CountriesTextFile.add(country);
				}
				System.out.println();
				userChoice = Validator.verifyChoice("1 - See the list of countries\n2 - Add a country\n3 - Exit\nEnter menu number: ");
			}
			
			System.out.println("Bye!");
			sc.close();
		}

	}
