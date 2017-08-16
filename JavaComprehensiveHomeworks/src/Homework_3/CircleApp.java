package Homework_3;
import java.util.Scanner;

public class CircleApp {
	public static void main (String [ ] args) {
		
		Scanner sc=new Scanner(System.in);
		String choice="y";
		System.out.println("Welcome to the Circle Tester");
		System.out.println();
	
		int count=0;
		double radius = 0;
		
		while(choice.equalsIgnoreCase("y")){
			
			System.out.print("Enter radius: ");
			radius = sc.nextDouble();
			Circle circle = new Circle(radius);
			circle.getCircumference();
			circle.getArea();
			System.out.println("Circumference: " + circle.getFormattedCircumference());
			System.out.println("Area: " + circle.getFormattedArea());
		
		    count = Circle.getObjectCount();
			
		    System.out.println();
			System.out.print("would you like to create another");
			choice=Validator.getChoice(sc, " \nContinue? (y/n): ");
			System.out.println();
		}
			System.out.println("Goodbye!");
			System.out.println("You created " + count + " Circles");
			sc.close();
	}

}
	
