package Homework_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountriesTextFile 
{
	private static String dirString = "D:/UCSC Extension Sillicon Valley/Java/Java Beginners/New folder/JavaComprehensiveHomeworks";
	private static String fileString = "countries.txt";
	
	public static void createFile()
	{
		Path dirPath = Paths.get(dirString);
		
		if(Files.notExists(dirPath)){
			try {
				Files.createFile(dirPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Path filePath = Paths.get(dirString, fileString);
		if (Files.notExists(filePath)){
			try {
				Files.createFile(filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void list(){
		
		try (BufferedReader in = new BufferedReader(new FileReader(fileString)))
		{
			String line;
			while((line = in.readLine()) != null)
			{
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void add(String country)
	{
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileString, true))))
		{
			out.println(country);
			out.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}

