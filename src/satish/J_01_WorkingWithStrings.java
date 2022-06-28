package satish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J_01_WorkingWithStrings {

	public static void main(String[] args) {
		String name = "Andra Satish";
		String[] names = name.split(" ");
		//List<String> listOfNames = Arrays.asList(names); // This is Immutable(can't change)
		List<String> listOfNames = new ArrayList<String>(Arrays.asList(names)); // This is Mutable
		listOfNames.add("Babu");
		System.out.println("Names Array : "+listOfNames);
		System.out.println("Retreive Name in Array : "+listOfNames.get(2));
		
		// Check specific word will be available or not
		if(listOfNames.contains("Andra")) {
			System.out.println("You are eligible to apply for the passport");			
		}else {
			System.out.println("You are not eligible");
		}
		
		// Retrieve specific Character
		System.out.println(listOfNames.get(0).charAt(2));
		
		// Looping over list of characters in string & check for specific character
		for(int i=0;i<name.length();i++) {
			if(name.charAt(i) == 'u') {
				System.out.println("Your search is available");							
			}
		}
	}

}
