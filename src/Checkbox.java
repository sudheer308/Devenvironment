import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkbox {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\BrowserDrivers\\Chrome\\chromedriver_v100.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(int i=0; i<checkbox.size() ; i++) {
        	checkbox.get(i).click();
        	
        	}
        Thread.sleep(1000);
        List<WebElement> checkbox1 = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(int i=0; i<checkbox1.size() ; i++) {
        	checkbox1.get(i).click();
        	
        	}
       
        	}
       
        	
        	}
        
        
         
       
		
	

//input[@type='checkbox']