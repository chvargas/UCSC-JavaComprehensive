package JavaComprehensiveThreadRunners;

import java.util.ArrayList;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * A class on charge of core operations of Marathon Race program.
 * 
 * @author Christian Vargas
 */

public class MarathonRace 
{
	
	/** The db. */
	private RunnersDataBaseDERBY db;   							// Database access
	
	/** The io. */
	private RunnersFilesXMLandTXT io; 	    					// XML/Text files
	
	/** The run list. */
	private RunnersList runList;  						// Runners objects
	
	/** The runners. */
	private static ArrayList<ThreadRunner> runners;
	
	/** The sc. */
	private static Scanner sc = new Scanner(System.in);
	
   /**
    * Class constructor.
    */
	public MarathonRace()
	{
		runList = new RunnersList();
	}

   /**
    * Displays menu program to the user.
    */
	public void displayMenu()
	{
		String s = "\nWelcome to the Marathon Race Runner Program\n\n"
				 + "Select your data source: \n\n"
				 + " 1. Derby database\n"
				 + " 2. XML file\n"
				 + " 3. Text file\n"
				 + " 4. Default two runners\n"
				 + " 5. Exit\n";
		System.out.println(s);
	}

   /**
    * Will check user's input from Program menu.
    *
    * @param min 	Minimum number of the menu
    * @param max 		Maximum number of the menu
    * @return choice 	A validated string number of the menu
    */	
	public int getChoice(int min, int max)
	{
		String prompt = "Enter your choice: ";
		int choice = Validator.getIntRange(prompt, min, max);  //Checking choice between range min and max
		return choice;
	}
	
   /**
    * Will check user's input (Filename), verifying whether extension file matches with respect to the data source.
    * 
    * @param s				A filename which user specified
    * @return fileName  	A validated filename
    */	
	public String getFileName(String s)
	{
		String prompt = "";
		String fileName;
		
		while (true)
		{
			if (s.equals("xml"))	 // Checking filename format extension (must be XLM)
			{ 
				prompt = "Enter XML file name: "; 	//Prompt asking user to enter text name file XML
				fileName = Validator.getString(prompt); //Calling Validator check string until a valid string is given.
				
				if (! fileName.contains(".xml")) // checking if filename string has .xml 
				{
					System.out.println("This is not .xml file.\n");
					continue;
				}
				break;
			}
			else if (s.equals("txt"))	// Checking filename format extension (must be TXT)
			{  
				prompt = "Enter text file name: ";		//Prompt asking user to enter text name file TXT
				fileName = Validator.getString(prompt); //Calling Validator check string until a valid string is given.
				
				if (! fileName.contains(".txt")) // checking if filename string has .txt
				{
					System.out.println("This is not .txt file.\n");
					continue;
				}
				break;
			}
		}
		return fileName;
	}

   /**
    * Wait until ENTER key from the user is given. 
    */	
	public void waitInput()
	{
		System.out.println();
		System.out.print("User press ENTER key to continue...");
		
		while (true)
		{
			if (sc.hasNextLine())
				sc.nextLine();
				break;
		}
	}
	
   /**
    * Getting runners from instance Runners List class, starting each runner thread.
    * 
    * @param s	A type of the data source for runners (default)
    */	
	
	public void startRace(String s)
	{
		if (s.equals("default"))
			runners = runList.getDefaultRunners();
		else
			runners = runList.getRunners();
		
		try
		{
			System.out.print("Ready ");  
			Thread.sleep(1300);   
			System.out.print("set...");
			Thread.sleep(1200);   
			System.out.println("Go!\n");
		}
		catch (Exception e){}
		
		for (ThreadRunner th: runners)
		{
			th.setDaemon(true);
			th.start();
		}
		
		for (ThreadRunner th: runners)
		{
			try
			{
				th.join();
			}
			catch (InterruptedException e)
			{
				System.out.println("The race was interrupeted.");
				break;
			}
		}
		
		runList.clearRunners();
	}
	
   /**
    * Reading runners data from the selected data source. (DataBase/XML/TXT)
    * 
    * @param fileName		A validated filename
    * @param s				A type of the data source for runners
    * @return				True boolean if runners were successfully created.
    */		
	public boolean createRunners(String fileName, String s)
	{
		if (s.equals("xml"))						//Checking if data source is XML
		{
			io = new RunnersFilesXMLandTXT(runList);
			return io.createRunnersXML(fileName);
		}
		else if (s.equals("txt"))					//Checking if data source is TXT
		{
			io = new RunnersFilesXMLandTXT(runList);
			return io.createRunnersTXT(fileName);
		}
		else if (s.equals("db"))					//Checking if data source is Data Base
		{
			db = new RunnersDataBaseDERBY(runList);
			return db.createRunnersDB();
		}
		return false;
	}

   /**
    * Only The winner thread can be called when it finishes the race.
    * interrupting all threads to concedes the race. 
    * 
    * @param runnerWinnerName			Thread name declared by the winner
    */	
	public static void finishRace(String runnerWinnerName)
	{
		System.out.flush();
		System.out.printf("The race is over! %s is the winner.\n\n", runnerWinnerName);
		
		for (ThreadRunner th: runners)
		{
			th.interrupt();
		}
	}
	
}