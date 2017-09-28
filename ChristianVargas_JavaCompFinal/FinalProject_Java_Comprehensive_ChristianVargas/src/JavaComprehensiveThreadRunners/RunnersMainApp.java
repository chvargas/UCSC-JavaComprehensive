
package JavaComprehensiveThreadRunners;


// TODO: Auto-generated Javadoc
/**
 * Main Runners APP program simulates a race between competitors
 * The runners differ in speed and how often they need to rest.
 * The first runner to reach 1000 wins the race.
 * When one of the runners finishes the race, the application declares that runner to be the winner and the other runner concedes.
 * @author Christian Vargas
 */

public class RunnersMainApp {	
   
   /**
    * Main method asking user choice 
    * 1.Database (derby) / 2. XML file / 3. Text file / 4. Default runners / 5. Exit
    *
    * @param args the arguments
    */
	public static void main(String[] args) 
	{
		MarathonRace m = new MarathonRace();   
		
		int choice = 0;
		String filename;
				
		while (choice != 5)				//checking Option different to 5, if user doesn't want to finish program
		{
			m.displayMenu();  			// Display menu with choices. (1 to 5) 1.Database (derby) / 2. XML file / 3. Text file / 4. Default runners / 5. Exit 
			choice = m.getChoice(1, 5);	// Validating choice from user between range 1-5
			
			switch (choice)
			{
				case 1:  //Will connect to Derby database to get runners information from there.
					
					if (m.createRunners(null, "db"))
						m.startRace("db");
					else
						System.out.println("Failed to create runners from the database");
					break;
				
				case 2:  //Getting information from XML file
					
					filename = m.getFileName("xml");
					if (m.createRunners(filename, "xml"))
						m.startRace("xml");
					else
						System.out.printf("Failed to create runners from %s\n", filename);
					break;
				
				case 3:  //Getting information from TXT file

					filename = m.getFileName("txt");
					if (m.createRunners(filename, "txt"))
						m.startRace("txt");
					else
						System.out.printf("Failed to create runners from %s\n", filename);
					break;
				
				case 4:  //Default runners
					
					m.startRace("default");
					break;
				
				case 5:  // Exit
					System.out.println("\nThank you for using my Marathon Race Program");
					System.out.println("\nJAVA Comprehensive UCSC Silicon Valley");
					System.out.println("Christian Vargas ");
					break;
			}
			if (choice != 5)
				m.waitInput();   // Press any key to continue...method checking input from user
		} 
	}
}