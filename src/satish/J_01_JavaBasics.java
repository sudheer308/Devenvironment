package satish;
import java.util.ArrayList;
import java.util.Arrays;

public class J_01_JavaBasics {
	public static void main(String[] args) {
		//------------------------------
		// Working with numbers
		//------------------------------
		int[] arr = new int[5];
		arr[0]=10; arr[1]=20; arr[2]=30; arr[3]=40; 
		System.out.println("Array1 Item : "+ arr[1]);
		
		
		int[] arr2 = {10,20,30,40,50};
		System.out.println("Array2 Item : "+ arr2[1]);
		
		//Normal for loop
		for(int i=0;i<arr2.length;i++) {
			System.out.println("Iteration of "+i+" value :"+arr2[i]);
		}
		
		//Enhanced for loop
		for(int i:arr2) {
			System.out.println("Enhanced for loop "+ i);
		}
		

		//------------------------------
		// Working with strings
		//------------------------------
		String[] names = {"sudheer","satish","mohan","ramu","ganesh"};
		System.out.println("String Names : "+ names[1]);
		
		//Normal for loop
		for(int i=0;i<names.length;i++) {
			System.out.println("Iteration of "+i+" value :"+names[i]);
		}
		
		//Enhanced for loop
		for(String name:names) {
			System.out.println("Enhanced for loop : "+ name);
		}
		
		//----------------------------------------------------------------------
		
		String[] states = {"AP","TN","TG","UP","MP","KN"};
		//Requirement AP,TG,MP - TN,UP-KN
		System.out.println("Length of array : "+ Arrays.asList(states));
		int i=1;
		for(;i<states.length;) {
			System.out.println(states[i]);
			i+=2;
		}
		
		// Array List
		String[] productsData = {"Lenovo","Acer"};
		ArrayList<String> products = new ArrayList<String>(Arrays.asList(productsData));
		products.add("Dell");
		products.add("HP");
		products.add(0, "Assus");
		
		System.out.println("List of products : "+products); // List of products : [Assus, Lenovo, Acer, Dell, HP]
		System.out.println("Index of HP : "+ products.indexOf("HP")); // Index of HP : 4
		System.out.println("Is Apple Exists in the list : "+ products.contains("Apple")); // Is Apple Exists in the list :  false
		System.out.println(products.get(2)); // Acer
		
		// Remove Dell value from products
		int dellIndex = products.lastIndexOf("Dell");
		if(dellIndex != -1) {
			System.out.println("Deleted "+products.get(dellIndex)+" product from products Array"); 
			// Deleted Dell product from products Array
			products.remove(dellIndex);
		}else {
			System.out.println("Delete one not existing in products Array");
		}

		
		System.out.println("Final Products  : "+ products); // Final Products  : [Assus, Lenovo, Acer, HP]
		
		// Check each character length should be greater than or equal to 5
		ArrayList<String> conditionalArray = new ArrayList<String>();
		for(String product:products) {
			if(product.length() >= 5) {
				conditionalArray.add(product);
			}
		}
		
		System.out.println("Conditional Array : "+ conditionalArray); // Conditional Array : [Assus, Lenovo]
		
		// Remove Duplicates from Products Array
		products.add("Lenovo");
		products.add("Acer");
		System.out.println("Duplicate Products : "+ products); // Duplicate Products : [Assus, Lenovo, Acer, HP, Lenovo, Acer]
		
		ArrayList<String> uniqueProducts = new ArrayList<String>();
		for(String product:products) {
			if(!uniqueProducts.contains(product)) {
				uniqueProducts.add(product);
			}
		}
		System.out.println("Unique Products : "+ uniqueProducts); // Unique Products : [Assus, Lenovo, Acer, HP]
		
	}
}
