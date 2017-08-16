package Homework_6;

import java.util.*; 
import java.io.*;
import javax.xml.stream.*;

public class MusicArtistsApp {

	public static void main(String[] args) {
		try			{
			// display a welcome message
		
			System.out.println("  Artist and Album Listing");

			// declare global variables
			String filename = "music_artists.xml";

			// read artists
			ArrayList <String> list = new ArrayList<String>();
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			FileReader fileReader = new FileReader(filename);
			XMLStreamReader reader = inputFactory.createXMLStreamReader(fileReader);
			
			while (reader.hasNext())
			{
				int eventType = reader.getEventType();
				switch (eventType)
				{
				case XMLStreamConstants.START_ELEMENT:
					String elementName = reader.getLocalName();
					if (elementName.equals("Name"))
					{
						String artist = reader.getElementText();
						list.add(artist);
					}
					break;
				default:
					break;
				}
				reader.next();
			}
			
			// print list of artists
			System.out.println();
			System.out.println("  Artists");
			System.out.println("  -------");

			for (String s : list) { System.out.println("  " + s); }

		// Reading Albums
			list = new ArrayList <String>();
			inputFactory = XMLInputFactory.newInstance();
			fileReader = new FileReader(filename);
			reader = inputFactory.createXMLStreamReader(fileReader);
			
			while (reader.hasNext())
			{
				int eventType = reader.getEventType();
				switch (eventType)
				{
				case XMLStreamConstants.START_ELEMENT:
					String elementName = reader.getLocalName();
					if (elementName.equals("Album"))
					{
						String album = reader.getElementText();
						list.add(album);
					}
					break;
				default:
					break;
				}
				reader.next();
			}
			
		//Printing list of albums
			System.out.println();
			System.out.println("  Albums");
			System.out.println("  ------");

			for (String s : list) {	System.out.println("  " + s); }


		//Reading artists and Cds
			
			list = new ArrayList <String>();
			inputFactory = XMLInputFactory.newInstance();
			fileReader = new FileReader(filename);
			reader = inputFactory.createXMLStreamReader(fileReader);
			
			while (reader.hasNext())
			{
				int eventType = reader.getEventType();
				switch (eventType)
				{
				case XMLStreamConstants.START_ELEMENT:
					String elementName = reader.getLocalName();
					if (elementName.equals("Name"))
					{
						String artist = reader.getElementText();
						list.add(artist);
					}
					else if (elementName.equals("CD"))
					{
						String album = reader.getElementText();
						list.add("        " + album);
					}
					break;
				default:
					break;
				}
				reader.next();
			}
			
		//Reading Artists and albums
			
			list = new ArrayList <String>();
			inputFactory = XMLInputFactory.newInstance();
			fileReader = new FileReader(filename);
			reader = inputFactory.createXMLStreamReader(fileReader);
			
			while (reader.hasNext())
			{
				int eventType = reader.getEventType();
				switch (eventType)	                {
				case XMLStreamConstants.START_ELEMENT:
					String elementName = reader.getLocalName();
					if (elementName.equals("Name"))	     {
						String artist = reader.getElementText();
						list.add(artist);
					}
					else if (elementName.equals("Album"))	  {
						String album = reader.getElementText();
						list.add("        " + album);
					}
					break;
				default:
					break;
				}
				reader.next();
			}
		//Printing list of artists and albums
			System.out.println();
			System.out.println("  Artists:  Albums");
			System.out.println("  ------------------");

			for (String s : list)
			{	System.out.println("  " + s);		}
		}

		catch (FileNotFoundException e)
		{	e.printStackTrace();	        }
		catch (XMLStreamException e)
		{	e.printStackTrace();	        }
	}
}
