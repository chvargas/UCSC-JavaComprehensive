package Homework_4;
public class MyValidator extends OOValidator {
	
	public MyValidator(){
		super();
	}
	
	public String getRequiredString(String prompt){
		
		System.out.print(prompt);
		boolean booleanStringIsValid = false;
		String userString = "";
		
		while (booleanStringIsValid == false){
			
			userString = sc.nextLine();  	// read user input
			
			if(userString.equals("")){
	        	System.out.println("Error! This entry is requred. Try again");
	        }
	        else{
	        	booleanStringIsValid=true;
	        }
		}
	    return userString;
	}
	
	public String getChoiceString(String prompt,String s1,String s2){
		
		boolean booleanStringIsValid = false;
    	String choice = null;
    	
    	while(booleanStringIsValid == false){
    		
    		System.out.print(prompt);
	        choice = sc.next();  	// read user input
	        
	        sc.nextLine(); // discard any other data entered on the line
	        if(choice.equalsIgnoreCase(s1) || choice.equalsIgnoreCase(s2) ){
	        	booleanStringIsValid=true;
	        }
	        else{
	        	System.out.println("Error! Entry must be '"+s1+"' or '"+s2+"'.Try again");
	        }
	       
    	}
        return choice;
	}
}