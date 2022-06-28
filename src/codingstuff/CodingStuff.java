package codingstuff;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CodingStuff {

	public static void main(String[] args) {
		
		/*
		 * String[] productsData = {"Lenovo","Acer"}; 
		 * 1 --> Add product "Dell" & "HP" 
		 * 2
		 * --> Add product "Assus" at Index 0
		 * 
		 *  3 --> Print all products
		 *  4 --> Findout
		 * Index of product "HP" 
		 * 
		 * 5 --> Check is Apple is present or not in Array, If
		 * present return true else it is false 
		 * 
		 * 6 --> get the product name for index 2 
		 * 
		 * 7
		 * --> Remove Dell product from Array, If present remove else it should print
		 * "Delete one not existing in products Array" 
		 * 
		 * 8 --> Check each character
		 * length, 
		 * If length of character greater than or equal to 5 then return those
		 * products 
		 * 
		 * 9 --> Add product "Lenovo" & "Acer" & remove duplicate product from
		 * products
		 */
		  
		String[] productsData = {"Lenovo","Acer"}; 
		List<String> productsdata = new ArrayList<String>(Arrays.asList(productsData));
		
		ArrayList<String> lenthofchar = new ArrayList<String>();
		
				
		
		productsdata.add("Dell");
		productsdata.add("HP");
		System.out.println("result of 1 " + productsdata);
		
		productsdata.add(3,"Assus");
		System.out.println("result of 2 "+productsdata);
		
		int indexofhp = productsdata.indexOf("HP");
		System.out.println("result of index "+indexofhp);

		System.out.println("Match Case : "+ productsdata.contains("Apple"));
		
//		for (String resultofproductsdata : productsdata) {			
//			if(resultofproductsdata.equals("Apple")) {
//				System.out.println("result of 4 "+ true );
//			}else {
//				System.out.println("result of 5 "+ false);
//			}
//		}
		
		productsdata.remove("Dell");
		
		System.out.println("result of 6 "+productsdata);

		for (String dellproduct : productsdata) 
		{
			if(dellproduct.equals("Dell")) 
			{
				System.out.println("result of 7 "+ "dellproduct one  in arry");
			}else 
			{
				System.out.println("result of 7 "+ "removed one not in arry");
				break;
			}
		}
		
		for (String charatersproducts : productsdata) {
			if(charatersproducts.length() >= 5) {
			lenthofchar.add(charatersproducts);
			}
		}
		System.out.println("result of 8 "+lenthofchar);		
		
		productsdata.add("Assus");
		productsdata.add("Acer");
		System.out.println(productsdata);
	    
		// [Lenovo, Acer, Assus, HP]
		
		ArrayList<String> unique = new ArrayList<String>();
		System.out.println("Unique : "+unique);
	    for(String product:productsdata) {
	    	if(!unique.contains(product)) {
	    		unique.add(product);
	    	}
	    }
	    System.out.println("Unique Values : "+ unique);
	    
	}

}
