import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.random.RandomGenerator.SplittableGenerator;

public class core_javabasics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int digit = 10;
		char chare = 'a';
		double dec = 1.2;
		String myname = "sudheer";

		System.out.println(digit + " " + "is the digit number");
		System.out.println(myname);

		// Array Declaration 1
		int[] dig = new int[3];
		dig[0] = 1;
		dig[1] = 4;
		dig[2] = 5;
		for (int d : dig) {
			System.out.println(d);
		}

		// Array Declaration 2
		String[] states = { "AP", "UP", "TN" };
		for (int i = 0; i < states.length; i++) {
			System.out.println(states[i]);
		}

		for (String s : states) {
			System.out.println(s);
		}

		// ArrayList
		ArrayList<String> buildings = new ArrayList<String>();
		buildings.add("commercial");
		buildings.add("temple");
		buildings.add("Hospitals");

		int SearchIndex = buildings.indexOf("Hospitals");

		System.out.println(SearchIndex);
		buildings.remove(SearchIndex);
		System.out.println(buildings);

		ArrayList<String> names = new ArrayList<String>();
		names.add("sudheer");
		names.add("satish");
		names.add("harish");
		names.add("suresh");

		// Print all the names
		// Check for harish name, If name presents print "search results found"
		// Findout name "suresh" index
		// remove satish name

		System.out.println(names);
		

		for (String name : names) {
			if (name == "harish") {
				System.out.println("search results found");
			}
		}

		System.out.println(names.indexOf("suresh"));

		System.out.println(names.indexOf("satish"));

		names.remove(1);
		System.out.println(names);

		// String

		String date = "12-04-1995";
		String[] dateofsplit = date.split("-");
		List<String> eachdate = new ArrayList<String>(Arrays.asList(dateofsplit));
		System.out.println(eachdate);
		System.out.println(eachdate.get(1));
		for (String strin : eachdate) {
			System.out.println(strin);
			if (strin.equals("04")) {
				System.out.println("result matched");
				break;
			}

		}

		String company = "hexamap solution pvt ltd";
		String[] cname = company.split(" ");

		
		List<String> cnames = new ArrayList<String>(Arrays.asList(cname));
		System.out.println(cnames);
		cnames.add("chennai");
		System.out.println(cnames);
		for (String splittedcompany : cnames)
		{
			System.out.println(splittedcompany);
			if (splittedcompany.equals("pvt"))
			{
				System.out.println("pvt matched");
				break;
			}
		}
        
		String word = "supers exllent";
		String[] eachletter = word.split(" ");
		//List<String> words = new ArrayList<String>(Arrays.asList(eachletter));
		//System.out.println(words);
		//System.out.println(words.indexOf("exllent"));
		
		System.out.println(eachletter[0]);
		System.out.println(eachletter[1]);
		
		for(int i=word.length()-1; i>=0; i--) 
		{
			System.out.println(word.charAt(i));
		}
		
		

	
	
	//fruits = ["graps","banana","orange","apple"]
	
	// find how many fruits
	// Search for orange, If exists "oranges available in search result"
	// add 'papaya' fruit in existing fruits
	// remove 'banana' fruit
	// add 'watermelon' at 2nd index
	// clear all the fruits
	
	
	String[] Fruits = {"graps","banana","orange","apple"};
	List<String> Fruit = new ArrayList<String>(Arrays.asList(Fruits));
	System.out.println(Fruit.size());
    
	for (int i = 0; i < Fruits.length; i++) 
	{
		System.out.println(Fruits[i]);
		if(Fruits[i]=="orange") 
		{
			System.out.println("oranges available in search result");
			break;
		}
	}
	
	
	Fruit.add("papaya");
	System.out.println(Fruit);
	
	Fruit.remove("banana");
	System.out.println(Fruit);
	
	
	Fruit.add(2,"watermelon");
	System.out.println(Fruit);
	
	Fruit.clear();
	System.out.println(Fruit);

	
	// salaries = [9800,10000,15000,800];
	// find how many salaries
	// Search salary greaterthan or equal to 15000 and how many
    // Search salary not equal to 800
	
     String[] salaries = {"9800","10000","15000","800"};
     List<String> salary = new ArrayList<String>(Arrays.asList(salaries));
     System.out.println(salary);
     for(String sal : salary) {
    	 if(Integer.valueOf(sal)  >= 15000) {
    		 System.out.println(sal);
    	 }
     }
     
  }


}







