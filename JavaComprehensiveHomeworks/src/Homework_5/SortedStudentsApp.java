package Homework_5;

import java.util.Scanner;
import java.util.Arrays;

public class SortedStudentsApp
{
    //Creating Scanner
	static Scanner sc = new Scanner(System.in);

	//Main Code Students Application (App)
    public static void main(String[] args)
    {
    	//Printing welcome console
    	System.out.println("---------- 5.1) Welcome to the Student Scores Application.---------- ");

        //Instantiating students count with getStudetCount() method
        //Getting number of students and creating the array with the students' length 
    	int studentCount = getStudentCount();
        Student[] arrayStudents = new Student[studentCount];


        // For Loop that will check students' length and will save students information 
        // (first name ,last name and Score) in the arrayStudents
        for (int i = 0; i < studentCount; i++)
        {
            System.out.println();                                                // print a blank line
            String lastName = getString("Student " + (i + 1) + " Last name: ");        // get last name
            String firstName = getString("Student " + (i + 1) + " First name: ");    // get first name
            int score = getScore("Student " + (i + 1) + " Score: ");                // get score
            arrayStudents[i] = new Student(lastName, firstName, score);                // add to array
        }

        // Sorting Students Array
        Arrays.sort(arrayStudents);

        // Printing Students Array
        System.out.println();						 // Printing blank line
        for (Student s : arrayStudents)      		 // for each Student in the array
            System.out.println(s.getSummaryLine());  // getting method from Student class to print students information
        System.out.println();               		 // Printing blank line

    }

    /*
     * getSring() method will validate that user input has been a string 
     */
    public static String getString (String prompt)
    {
        String userString = "";
        boolean checkBoolean = false;

        while (!checkBoolean)          // looping until user enters a non-blank line
        {
            System.out.print(prompt);
            userString = sc.nextLine();
            
            if (!userString.equals(""))
                checkBoolean = true;
        }
        return userString;
    }
    
    /*
     * gettingStudentCount() method that will save number the students to enter to the array
     */
    public static int getStudentCount()
    {
        int studentCount = 0;
        boolean validBoolean = false;

        while (!validBoolean)
        {
            System.out.print("\nEnter number of students to enter: " );
           
            if (sc.hasNextInt())                // checking scanner with an integer
            {
                studentCount = sc.nextInt();     // saving integer as the new students count number
                if (studentCount > 0)            // changing validBollean to go out of the for loop, when the condition will be true.
                    validBoolean = true;
            }
            sc.nextLine();                        // cleaning and discarding data
        }
        return studentCount;                      // returning studentCount variable
    }
    
    /*
     * getScore method will save and check student student score between a range form 0 to 100
     */
    public static int getScore(String prompt)
    {
        int studentScore = 0;
        boolean checkBoolean = false;

        while (!checkBoolean)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())       //checking user input has been an integer
            {
                studentScore = sc.nextInt();     // saving user input
                
                if (studentScore >= 0 && studentScore <= 100) // validating input between range 0 to 100
                    checkBoolean = true;
            }
            sc.nextLine();                            // cleaning Scanner
        }
        return studentScore;                          // return score
    }

}