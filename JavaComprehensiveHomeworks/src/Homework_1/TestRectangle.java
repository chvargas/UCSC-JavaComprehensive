package Homework_1;
import java.util.Scanner;

public class TestRectangle {

	public static void main(String[] args) {
		
		//Printing Principal Line in screen
		System.out.println("Welcome to the Area and Perimeter Calculator");
		
		//Asking user enter Length and Width
		Scanner scLength = new Scanner (System.in);
		System.out.print("Please enter length : ");
		double L = scLength.nextDouble();
        Scanner scWidth = new Scanner (System.in);
        System.out.print("Please enter width : ");
        double W = scWidth.nextDouble();
        
        //Calculating Area
        double RectangleArea;
        Rectangle unitRectangle = new Rectangle(L,W); 
        RectangleArea = unitRectangle.FindArea();
        System.out.println("The area is : " + RectangleArea);
        
        //Calculating Perimeter
        double RectanglePermiter;
        Rectangle perimRectangle = new Rectangle(L,W);
        RectanglePermiter = perimRectangle.FindPerim();
        System.out.println("The perimeter is : " + RectanglePermiter);

        scLength.close();
        scWidth.close();
	}

}
