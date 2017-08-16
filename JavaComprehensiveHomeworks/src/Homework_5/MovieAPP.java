package Homework_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MovieAPP {
	 public static void main(String[] args) {

	        // Initialize
	        Scanner scan = new Scanner(System.in);
	        Validator validate = new Validator(scan);

	        int userInput;
	        String userContinue;

	        // Print App Title
	        printAppTitle();

	        // Make new ArrayList from MovieIO
	        ArrayList<Movie> moviesList = makeMovieList();

	        // Sort Movies by Category
	        sortByCategory(moviesList);

	        printAllMovies(moviesList);

	        System.out.println("\nTo search movies by category, please enter corresponding number [1/2/3/4/5/6]");

	        do {
	            
	        	System.out.println("[1]-Animated\n[2]-Comedy\n[3]-Drama\n[4]-Horror\n[5]-SciFi\n[6]-All Movies");
	            System.out.println();
	            
	            // Getting input from user between 1 - 6, validating input from Validator Class
	            userInput = validate.getIntWithinRange("", 1, 6);

	            // Get movies based on userInput
	            getMoviesByCategory(userInput, moviesList);
	            System.out.println();

	            // Asking user to search for another yes or to set loop
	            System.out.print("Would you like to continue searching? yes / no   ");
	            userContinue = scan.next();

	        } while (userContinue.equalsIgnoreCase("y") || userContinue.equalsIgnoreCase("yes"));

	        System.out.println(); 
	        System.out.println("Thank you for using the Movie App! Goodbye!");
	    }

	    // Building ArrayList from MovieIO class
	    public static ArrayList<Movie> makeMovieList ()
	    {
	        // MakingArrayList for Movies
	        ArrayList<Movie> moviesList = new ArrayList<>();

	        
	        // Adding movies in MovieIO to a new moviesList
	        for (int i = 1; i <= 100; i++ )
	        {
	            moviesList.add(MovieIO.getMovie(i));
	        }

	        return moviesList;
	    }

	    // Sorting Movies Alphabetically by Category
	    public static ArrayList<Movie> sortByCategory (ArrayList<Movie> array)
	    {

	        Collections.sort(array, new Comparator<Movie>() 
	        {
	            @Override
	            public int compare(Movie movie2, Movie movie1) 
	            {
	                return movie2.getCategory().compareTo(movie1.getCategory());
	            }
	        });

	        return array;
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

	    // Get Movies by Category based on user input
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

	    // Print movies in specific category
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