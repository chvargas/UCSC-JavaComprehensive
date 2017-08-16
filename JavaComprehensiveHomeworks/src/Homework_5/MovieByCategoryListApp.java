package Homework_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MovieByCategoryListApp
{
    static Scanner sc = new Scanner(System.in);
    static ArrayList <Movie> movies = getMovies(); // fills the array list
    static int userInput;
    static String userContinue;
    static Validator validate = new Validator(sc);

    public static void main(String[] args)
    {
    	do{
    		System.out.println("---------- Welcome to the Movie List Application.---------- \n ");
            System.out.println ("There are " + movies.size() + " movies in the list.\n");
            System.out.println("To search movies by category, please enter corresponding category or number.");
            System.out.println("1.Animated\n2.Comedy\n3.Drama\n4.Horror\n5.SciFi\n6.All Movies");
            userInput = validate.getIntWithinRange("", 1, 6);  
            getMoviesByCategory(userInput, movies);
            System.out.println();
            System.out.print("Would you like to continue searching? yes / no   ");
            userContinue = sc.next();
    		
    	}while(userContinue.equalsIgnoreCase("y") || userContinue.equalsIgnoreCase("yes"));
        
        System.out.println("Thanks for ussing movies app.\nGood Bye!");
    }
    
    public static ArrayList<Movie> getMovies()
    {
        Movie m;
        ArrayList<Movie> movies = new ArrayList<>();
        
        for (int i = 1; i <= 100; i++)
        {
            m = MovieIO.getMovie(i);
            movies.add(m);
        }
        return movies;
    }

    public static String getString(String prompt)
    {
        String s = "";
        boolean checkBoolean = false;

        while (!checkBoolean)       // loops until user enters a non-blank line
        {
            System.out.print(prompt);
            s = sc.nextLine();
            if (!s.equals(""))
                checkBoolean = true;
        }
        return s;
    }

    public static boolean getContinue()
    {
        System.out.print("Continue? (y/n): " );
        String choice = sc.nextLine();
        
        if (choice.equalsIgnoreCase("Y"))
            return true;
        else
            return false;
    }

    public static ArrayList<Movie> sortByTitle (ArrayList<Movie> array)
    {

        Collections.sort(array, new Comparator<Movie>() 
        {
            @Override
            public int compare(Movie movie2, Movie movie1) 
            {
                return movie2.getTitle().compareTo(movie1.getTitle());
            }
        });

        return array;
    }
  
    public static void getMoviesByCategory (int userInput, ArrayList<Movie> array)
    {
        sortByTitle(array);

        switch (userInput){
            case 1:
                printCategory(array, "animated");
                break;
            case 2:
                printCategory(array, "comedy");
                break;
            case 3:
                printCategory(array, "drama");
                break;
            case 4:
                printCategory(array, "horror");
                break;
            case 5:
                printCategory(array, "scifi");
                break;
            case 6:
                printAllMovies(array);
                break;
            default:
                System.out.println("Something went wrong, please try again");
        }
    }

    public static void printCategory (ArrayList<Movie> array, String category){

        int numberInCategory = 0;

        System.out.println("-- " + category.toUpperCase() + " --");
        for(Movie movie : array) {
            if (category.equalsIgnoreCase(movie.getCategory())) {
                System.out.printf("%-35s", movie.getTitle());
                numberInCategory++;
                System.out.println(); // next line
            }
        }

        System.out.println(); // skip line before number of movies prints
        if (numberInCategory == 1){
            System.out.println(numberInCategory + " movie was found in the " + category + " category.");
        } else {
            System.out.println(numberInCategory + " movies were found in the " + category + " category.");
        }

        System.out.println(); //skip line before next prompt
    }

    // Print Entire movieList (Title and Category)
    public static void printAllMovies (ArrayList<Movie> array){
        for(Movie movie : array) {
            System.out.printf("%-35s %-20s", movie.getTitle(), movie.getCategory());
            System.out.println(); // next line
        }
    }

    // Print App's Title
    public static void printAppTitle (){
        System.out.println("------ Welcome to the Movie List Application. ------");
        System.out.println(); // skip line
    }

}

