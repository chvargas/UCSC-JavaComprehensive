package Homework_3;
import java.util.Scanner;

public class PigLatinTranslator {
	final static String vowels = "aeiouAEIOU";

	public static void main(String[] args) {
		System.out.println("Welcome to Pig Latin Translator!");
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		String choice="y";
		String input, results;
		
		while(choice.equalsIgnoreCase("y")){
			
			System.out.println("Enter a line to be translated: ");
			System.out.println();
			
			input = scan.nextLine();
			input = input.toLowerCase();
			String[] words = input.split(" ");
			
			for (int i = 0; i < words.length; i++) {
				if (isVowel(words[i])) {
					results = convertToPigLatinForVowel(words[i]);
					
				} else {
					
					results = convertToPigLatinForConsonant(words[i]);
				}
				System.out.print(results + " ");
				System.out.println();
			}

		    System.out.println();
			System.out.print("Translate another line?");
			choice=Validator.getChoice(scan, " \nContinue? (y/n): ");
			System.out.println();
		}
			System.out.println("Goodbye!");
			scan.close();
	}
		
	private static String convertToPigLatinForConsonant(String word) {
		int split = firstVowel(word);
		return word.substring(split) + word.substring(0, split) + "ay";
	}

	private static String convertToPigLatinForVowel(String word) {
		word += "way";
		return word;
	}

	private static boolean isVowel(String word) {
	
		if (word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o'
				|| word.charAt(0) == 'u') {
			return true;
		} else {
			return false;
		}
	}

	private static int firstVowel(String words) {
		words = words.toLowerCase();
		for (int i = 0; i < words.length(); i++)
			if (words.charAt(i) == 'a' || words.charAt(i) == 'e' || words.charAt(i) == 'i' || words.charAt(i) == 'o'
					|| words.charAt(i) == 'u')
				return i;
		return 0;
	}
}
