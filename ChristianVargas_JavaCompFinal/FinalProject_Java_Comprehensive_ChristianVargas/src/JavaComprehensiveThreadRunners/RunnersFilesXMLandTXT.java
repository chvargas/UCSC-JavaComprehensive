package JavaComprehensiveThreadRunners;



import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

// TODO: Auto-generated Javadoc
/**
 * A class to handle information from XML and TXT files .
 *
 * @author Christian Vargas.
 */

public class RunnersFilesXMLandTXT 
{
	
	/** The run list. */
	private RunnersList runList;
	
	/** The dir path. */
	private String dirPath;
	
   /**
    * Class constructor.
    *
    * @param runList An instance of RunnersList class which holds all runners objects
    */
	
	public RunnersFilesXMLandTXT(RunnersList runList)
	{
		this.runList = runList;
		dirPath = "Resources";  			//Setting path Resources to get info from TXT and XML files
	}
	
   /**
    * Will create runners from XML file.
    * @param fileName	Validated XML filename 
    * @return			TRUE Boolean when runners were created satisfactorily
    */	
	
	public boolean createRunnersXML(String fileName)
	{
		Path filePath = Paths.get(dirPath, fileName);
		try (FileReader file = new FileReader(filePath.toFile()))
		
		{
			XMLInputFactory inputFactory = XMLInputFactory.newFactory();
			XMLStreamReader reader = inputFactory.createXMLStreamReader(file);
			
			String runnersName = "";				//Initialization 
			double runnersSpeed = 0;
			double restPercentage = 0;
			
			while(reader.hasNext()) 				// Parse XML file to create runners
			{
				int eventType = reader.getEventType();
				switch (eventType)
				{
					case XMLStreamConstants.START_ELEMENT:
						
						String elementName = reader.getLocalName();
						if (elementName.equals("Runner"))
						{
							runnersName = reader.getAttributeValue(0);
						}
						if (elementName.equals("RunnersMoveIncrement"))
						{
							runnersSpeed = Double.parseDouble(reader.getElementText());
						}
						if (elementName.equals("RestPercentage"))
						{
							restPercentage = Double.parseDouble(reader.getElementText());
						}
						break;
					
					case XMLStreamConstants.END_ELEMENT:
						
						elementName = reader.getLocalName();
						if (elementName.equals("Runner"))
						{
							runList.addRunner(runnersName, runnersSpeed, restPercentage);  // create a runner
						}
						break;
					
					default:
						break;
				}
				reader.next();
			}
			return true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File was not Found\n");
			return false;
		}
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
   /**
    * Will create runners from TXT file.
    * @param filename	A validated TXT filename 
    * @return			TRUE Boolean when runners were created satisfactorily
    */	
	public boolean createRunnersTXT(String filename)
	{
		String line;
		Path filePath = Paths.get(dirPath, filename);
		try(BufferedReader in = new BufferedReader(new FileReader(filePath.toFile())))
		{
			line = in.readLine();
			while(line != null) 			// Parse TXT file to create runners
			{
				String [] runnerArray = line.split(",");
				String runnersName = runnerArray[0].trim();
				int runnersSpeed = Integer.parseInt(runnerArray[1].trim());
				int restPercentage = Integer.parseInt(runnerArray[2].trim());
				runList.addRunner(runnersName, runnersSpeed, restPercentage); 
				line = in.readLine();
			}
			return true;
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File was not Found\n");
			return false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}

}