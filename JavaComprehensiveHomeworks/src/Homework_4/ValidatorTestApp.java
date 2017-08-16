package Homework_4;
import java.util.Scanner;

public class ValidatorTestApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		OOValidator ooValidatorObject = new OOValidator(sc);
		MyValidator myValidatorObject = new MyValidator();
		
		System.out.println("Welcome to the Validation Tester Application");
		System.out.println();
		System.out.println("Int Test");
		int intUserInput = ooValidatorObject.getIntWithinRange("Enter an integer between -100 and 100: ",-101,100);
		
		System.out.println();
		System.out.println("Double Test");
		double doubleUserInput = ooValidatorObject.getDoubleWithinRange("Enter any number between -100 and 100: ",-101,101);
		
		System.out.println();
		System.out.println("Require String Test");
		String stringUserInput = myValidatorObject.getRequiredString("Enter your email address: ");
		
		System.out.println();
		System.out.println("required Choice Test");
		String choiceUserInput = myValidatorObject.getChoiceString("Select one (x/y) :","x","y");
		}

		}